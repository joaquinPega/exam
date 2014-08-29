package org.simple.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.exceptions.StartDataBaseException;
import org.simple.model.Language;

public class LanguageDAO implements GenericDAO<Language> {

	private Session sesion;
	private Transaction tx;

	private void startOperation() throws StartDataBaseException {
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
		} catch (ExceptionInInitializerError e) {
			throw new StartDataBaseException(e.getMessage());
		}
	}

	@Override
	public void save(Language t) throws ObjectDuplicateException {
		this.startOperation();
		try {
			sesion.save(t);
			tx.commit();
		} catch (HibernateException e) {
			throw new ObjectDuplicateException(e.getMessage());
		} finally {
			sesion.close();
		}
	}

	@Override
	public void update(Language t) throws ObjectNotFoundException {
		this.startOperation();
		try {
			sesion.update(t);
			tx.commit();
		} catch (HibernateException e) {
			throw new ObjectNotFoundException(e.getMessage());
		} finally {
			sesion.close();
		}

	}

	@Override
	public void delete(Language t) throws ObjectNotFoundException {
		this.startOperation();
		try {
			sesion.delete(t);
			tx.commit();
		} catch (HibernateException e) {
			throw new ObjectNotFoundException(e.getMessage());
		} finally {
			sesion.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Language> search(String filter) throws ObjectNotFoundException {
		this.startOperation();
		List<Language> languages = null;
		try {
			Query query = sesion.createQuery("FROM Language L WHERE L.name="
					+ filter);
			languages = (List<Language>) query.list();
		} catch (HibernateException e) {
			throw new ObjectNotFoundException(e.getMessage());
		} finally {
			sesion.close();
		}
		return languages;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Language> getAll() throws ObjectNotFoundException {
		this.startOperation();
		List<Language> languages = null;
		try {
			Query query = sesion.createQuery("FROM Language");
			languages = (List<Language>) query.list();
		} catch (HibernateException e) {
			throw new ObjectNotFoundException(e.getMessage());
		} finally {
			sesion.close();
		}
		return languages;
	}

}
