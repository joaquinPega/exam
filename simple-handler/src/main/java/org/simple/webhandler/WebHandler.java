package org.simple.webhandler;

import java.util.List;

import org.simple.exceptions.CouldNotFinishOperationException;
import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.Language;
import org.simple.model.Manager;
import org.simple.model.User;
import org.simple.persistence.GenericDAO;
import org.simple.persistence.LanguageDAO;
import org.simple.persistence.ManagerDAO;
import org.simple.persistence.UserDAO;

/**
 * Business logic of the aplication
 * 
 * @author Joaquin Pega 2014 <joaquin.pega@globant.com> ; Artiom Amerhanov
 *         (artiom.amerhanov@globant.com)
 * 
 *
 */
public class WebHandler {
	private static WebHandler instance;
	private GenericDAO<User> ud;
	private GenericDAO<Manager> md;
	private GenericDAO<Language> ld;
	private List<User> users = null;
	private List<Language> languages = null;
	private List<Manager> managers = null;

	/**
	 * Singleton
	 * 
	 * @return Instancia de WebHandler
	 */
	public static WebHandler getInstance() {
		if (instance == null) {
			instance = new WebHandler();
		}
		return instance;
	}

	private WebHandler() {
		startAplication();
	}

	/**
	 * 
	 * @throws CouldNotFinishOperationException
	 */
	private void startAplication() throws CouldNotFinishOperationException {
		this.ud = new UserDAO();
		this.md = new ManagerDAO();
		this.ld = new LanguageDAO();
	}

	/**
	 * @param filter parametro para la busqueda
	 * @return la lista de usuarios
	 * @throws CouldNotFinishOperationException
	 */
	
	public List<User> search(String filter)
			throws CouldNotFinishOperationException {
		try {
			users = ud.search(filter);
			return users;
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("search user fail");
		}
	}

	/***
	 * Retorna la lista de usuarios
	 * 
	 * @return users
	 * @throws CouldNotFinishOperationException
	 */
	public List<User> getListUsers() throws CouldNotFinishOperationException {
		try {
			users = ud.getAll();
			return users;
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Get user list fail");
		}
	}

	/***
	 * Eliminar usuario
	 * 
	 * @param user
	 * @throws CouldNotFinishOperationException
	 */
	public void deleteUser(User user) throws CouldNotFinishOperationException {
		try {
			ud.delete(user);
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("delete user fail");
		}
	}

	/**
	 * Guardar usuario
	 * 
	 * @param user
	 */
	public void saveUser(User user) {
		try {
			ud.save(user);
		} catch (ObjectDuplicateException e) {
			throw new CouldNotFinishOperationException("Save user fail");
		}
	}

	/**
	 * Guardar modificaciones de usuario
	 * 
	 * @param user
	 * @throws CouldNotFinishOperationException
	 */
	public void updateUser(User user) throws CouldNotFinishOperationException {
		try {
			ud.update(user);
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Update user fail "
					+ e.getMessage());
		}
	}

	/**
	 * Guardar manager
	 * 
	 * @param manager
	 */
	public void saveManager(Manager manager) {
		try {
			md.save(manager);
		} catch (ObjectDuplicateException e) {
			throw new CouldNotFinishOperationException("Save manager fail");
		}
	}

	/***
	 * Guardar idioma
	 * 
	 * @param language
	 */
	public void saveLanguage(Language language) {
		try {
			ld.save(language);
		} catch (ObjectDuplicateException e) {
			throw new CouldNotFinishOperationException("Save language fail");
		}
	}

	/**
	 * Guardar lista de idiomas
	 * 
	 * @return languages
	 * @throws CouldNotFinishOperationException
	 */
	public List<Language> getListLanguages()
			throws CouldNotFinishOperationException {
		try {
			languages = ld.getAll();
			return languages;
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Get user list fail");
		}
	}

	/**
	 * Retornar lista de managers
	 * 
	 * @return managers
	 * @throws CouldNotFinishOperationException
	 */
	public List<Manager> getListManagers()
			throws CouldNotFinishOperationException {
		try {
			managers = md.getAll();
			return managers;
		} catch (ObjectNotFoundException e) {
			throw new CouldNotFinishOperationException("Get user list fail");
		}
	}
}
