package org.simple.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.simple.exceptions.StartDataBaseException;

public abstract class HibernateOperations {
	protected Session sesion; 
    protected Transaction tx;
    
    protected void startOperation() throws StartDataBaseException {
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
		} catch (ExceptionInInitializerError e) {
			throw new StartDataBaseException(e.getMessage());
		}
	}
}
