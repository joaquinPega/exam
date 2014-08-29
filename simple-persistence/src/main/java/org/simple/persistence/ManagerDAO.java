package org.simple.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.exceptions.StartDataBaseException;
import org.simple.model.Manager;

public class ManagerDAO implements GenericDAO<Manager> {

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
	public void save(Manager t) throws ObjectDuplicateException {
		this.startOperation();
		try{
			sesion.save(t);
			tx.commit();
		}catch(HibernateException e){
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
			Query query = sesion.createQuery("FROM Manager M WHERE M.name="+filter);
			managers=(List<Manager>)query.list();		
		}catch(HibernateException e){
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
			throw new ObjectNotFoundException(e.getMessage());
		}finally{
			sesion.close();
		}
		return managers;
	}

}
