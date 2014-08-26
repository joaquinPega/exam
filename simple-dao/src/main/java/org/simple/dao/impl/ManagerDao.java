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
		Query query=s.createQuery("FROM Manager M WHERE M.name = :name");		
		query.setParameter("name",name );			
		Manager manager= (Manager) query.uniqueResult();			
		if(manager==null){
			throw new UserNotFoundException("manager not found in database");
		}else{
			return manager;			
		}
	}
	private void beginTransaction(){
		s = HibernateUtil.getSessionFactory().getCurrentSession();
		if(!s.getTransaction().isActive()){
			s.beginTransaction();
		}
	}
}
