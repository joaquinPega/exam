package org.simple.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.User;
/**@see GenericDAO
 * 
 * @author joaquin.pega; Artiom Amerhanov (artiom.amerhanov@globant.com)
 *
 */
public class UserDAO extends HibernateOperations implements GenericDAO<User> {


	@Override
	public void save(User user) throws ObjectDuplicateException {
		this.startOperation();
		try{
			sesion.save(user);
			tx.commit();
		}catch(HibernateException e){
			throw new ObjectDuplicateException(e.getMessage());
		}finally{
			sesion.close();
		}
		
	}

	@Override
	public void update(User t) throws ObjectNotFoundException {
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
	public void delete(User t) throws ObjectNotFoundException {
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
	public List<User> search(String filter) throws ObjectNotFoundException {
		this.startOperation();
		List<User> usuarios=null;
		try{
			Query query = sesion.createQuery("FROM User U WHERE U.name LIKE '"+filter + "' OR U.company LIKE '"+ filter+ "' OR U.experience LIKE '"+filter+"'");
			usuarios=(List<User>)query.list();		
		}catch(HibernateException e){
			throw new ObjectNotFoundException(e.getMessage());
		}finally{
			sesion.close();
		}
		return usuarios;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() throws ObjectNotFoundException {
		this.startOperation();
		List<User> usuarios=null;
		try{
			Query query = sesion.createQuery("FROM User");
			usuarios=(List<User>)query.list();		
		}catch(HibernateException e){
			throw new ObjectNotFoundException(e.getMessage());
		}finally{
			sesion.close();
		}
		return usuarios;
	}

}
