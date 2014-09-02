package org.simple.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.Manager;
/**
 * @see GenericDAO
 * @author joaquin.pega; Artiom Amerhanov (artiom.amerhanov@globant.com)
 *
 */
public class ManagerDAO extends HibernateOperations implements GenericDAO<Manager> {


	@Override
	public void save(Manager t) throws ObjectDuplicateException {
		this.startOperation();
		try{
			sesion.save(t);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw new ObjectDuplicateException(e.getMessage());
		}finally{
			sesion.close();
		}
	}

	@Override
	public void update(Manager t) throws ObjectNotFoundException {
		this.startOperation();
		try{
			sesion.update(t);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw new ObjectNotFoundException(e.getMessage());
		}finally{
			sesion.close();
		}
		
	}

	@Override
	public void delete(Manager t) throws ObjectNotFoundException {
		this.startOperation();
		try{
			sesion.delete(t);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw new ObjectNotFoundException(e.getMessage());
		}finally{
			sesion.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> search(String filter) throws ObjectNotFoundException {
		this.startOperation();
		List<Manager> managers=null;
		try{
			Query query = sesion.createQuery("FROM Manager M WHERE M.name LIKE '"+filter+"'");
			managers=(List<Manager>)query.list();		
		}catch(HibernateException e){
			tx.rollback();
			throw new ObjectNotFoundException(e.getMessage());
		}finally{
			sesion.close();
		}
		return managers;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> getAll() throws ObjectNotFoundException {
		this.startOperation();
		List<Manager> managers=null;
		try{
			Query query = sesion.createQuery("FROM Manager");
			managers=(List<Manager>)query.list();		
		}catch(HibernateException e){
			tx.rollback();
			throw new ObjectNotFoundException(e.getMessage());
		}finally{
			sesion.close();
		}
		return managers;
	}

}
