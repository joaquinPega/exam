package org.simple.persistence;

import java.util.List;

import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;

/**
 * 
 * @author Joaquin Pega (joaquin.pega@globant.com); Artiom 
 * 
 *
 * @param <T> T Elemento del cual se va a persistir
 */
public interface GenericDAO<T> {
	public void save(T t) throws ObjectDuplicateException;
	public void update(T t) throws ObjectNotFoundException;
	public void delete(T t)throws ObjectNotFoundException;
	public List<T> search(String query)throws ObjectNotFoundException;
	
}
