package org.simple.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.Language;
/**@see GeneriDAO
 * Implements the genericDAO for the Language model class
 * @author joaquin.pega; Artiom Amerhanov (artiom.amerhanov@globant.com)
 *
 */
public class LanguageDAO extends HibernateOperations implements GenericDAO<Language> {

	@Override
	public void save(Language t) throws ObjectDuplicateException {
		this.startOperation();
		try {
			sesion.save(t);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
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
			tx.rollback();
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
			tx.rollback();
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
			Query query = sesion.createQuery("FROM Language L WHERE L.name LIKE '"+ filter+"'");
			languages = (List<Language>) query.list();
		} catch (HibernateException e) {
			tx.rollback();
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
			tx.rollback();
			throw new ObjectNotFoundException(e.getMessage());
		} finally {
			sesion.close();
		}
		return languages;
	}

}
