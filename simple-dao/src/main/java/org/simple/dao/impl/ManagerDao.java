package org.simple.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.simple.exceptions.DataBaseErrorException;
import org.simple.exceptions.UserNotFoundException;
import org.simple.hibernate.HibernateUtil;
import org.simple.model.Manager;

public class ManagerDao {
	private Session s;
	
	public void save(Manager manager) throws DataBaseErrorException {
		beginTransaction();
		try{
			if(getById(manager.getName())!=null){

				throw new DataBaseErrorException("User already in data base");
			}
			
		}catch(UserNotFoundException e){
			s.save(manager);
			s.getTransaction().commit();
		}
	}
	public Manager getById(String name) throws UserNotFoundException {
		beginTransaction();
		Query query=s.createQuery("FROM Manager M WHERE M.name = :name");		//hql busca un usuario con el email
		query.setParameter("name",name );			//asigna email del parametro a la query
		Manager manager= (Manager) query.uniqueResult();			//trae un solo resultado query.setMaxResults(1),
		if(manager==null){
			throw new UserNotFoundException("manager not found in database");
		}else{
			return manager;			//devuelve el usuario
		}
	}
	private void beginTransaction(){
		s = HibernateUtil.getSessionFactory().getCurrentSession();
		if(!s.getTransaction().isActive()){
			s.beginTransaction();
		}
	}
}
