package org.simple.webhandler;

/*
 * Meter String a tabla en la cual el servlet busca cual pagina devolver o mensaje mostrar
 */

import java.util.List;

import org.simple.exceptions.CouldNotFinishOperationException;
import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.persistence.LanguageDAO;
import org.simple.persistence.ManagerDAO;
import org.simple.persistence.UserDAO;

public class WebHandler {
	private static WebHandler instance;
	private UserDAO ud;
	private ManagerDAO md;
	private LanguageDAO ld;
	private List<User> users = null;
	private List<Language> languages = null;
	private List<Manager> managers = null;

	public static WebHandler getInstance() {
		if (instance == null) {
			instance = new WebHandler();
		}
		return instance;
	}

	private WebHandler() {
		startAplication();
	}

	private void startAplication()throws CouldNotFinishOperationException {
		this.ud = new UserDAO();
		this.md = new ManagerDAO();
		this.ld = new LanguageDAO();
	}

	public List<User> search(String filter)throws CouldNotFinishOperationException {
		try {
			users = ud.search(filter);
			return users;
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("search user fail");
		}
	}

	public List<User> getListUsers()
			throws CouldNotFinishOperationException {
		try {
			users = ud.getAll();
			return users;
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Get user list fail");
		}
	}

	public void deleteUser(User user) throws CouldNotFinishOperationException {
		try {
			ud.delete(user);
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("delete user fail");
		}
	}

	public void saveUser(User user) {
		try {
			ud.save(user);
		} catch (ObjectDuplicateException e) {
			throw new CouldNotFinishOperationException("Save user fail");
		}
	}

	public void updateUser(User user) throws CouldNotFinishOperationException {
		try {
			ud.update(user);
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Update user fail");
		}
	}
	public void saveManager(Manager manager){
		try{
			md.save(manager);
		}catch(ObjectDuplicateException e){
			throw new CouldNotFinishOperationException("Save manager fail");
		}
	}
	public void saveLanguage(Language language){
		try{
			ld.save(language);
		}catch(ObjectDuplicateException e){
			throw new CouldNotFinishOperationException("Save language fail");
		}
	}
	public List<Language> getListLanguages()throws CouldNotFinishOperationException{
		try {			
			languages = ld.getAll();
			return languages;
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Get user list fail");
		}
	}
	public List<Manager> getListManagers()throws CouldNotFinishOperationException{
		try {			
			managers = md.getAll();
			return managers;
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Get user list fail");
		}
	}
}
