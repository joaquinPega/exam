package org.simple.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.simple.dao.UserDao;
import org.simple.exceptions.DataBaseErrorException;
import org.simple.exceptions.UserNotFoundException;
import org.simple.hibernate.HibernateUtil;
import org.simple.model.User;

public class UserDaoImpl implements UserDao {
	private Session s;
	
	@Override
	public void save(User user) throws DataBaseErrorException {
		beginTransaction();
		try{
			getById(user.getEmail());
			s.save(user);
			s.getTransaction().commit();
		}catch(UserNotFoundException e){
			throw new DataBaseErrorException("User already in data base");
		}
	}

	@Override
	public User getById(String email) throws UserNotFoundException {
		beginTransaction();
		Query query=s.createQuery("FROM User U WHERE U.email = :email");		//hql busca un usuario con el email
		query.setParameter("email",email );			//asigna email del parametro a la query
		User usuario= (User) query.uniqueResult();			//trae un solo resultado query.setMaxResults(1),
		if(usuario==null){
			throw new UserNotFoundException("User not found in database");
		}else{
			return usuario;			//devuelve el usuario
		}
	}

	@Override
	public List<User> getByName(String name) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getByCompany(String company) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getByExperience(String experience)
			throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findMany(String query) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void beginTransaction(){
		s = HibernateUtil.getSessionFactory().getCurrentSession();
		if(!s.getTransaction().isActive()){
			s.beginTransaction();
		}
	}

}
