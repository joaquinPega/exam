package org.simple.persistence;

import java.util.List;

import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;

/**Generic interface of Data access objects
 * 
 * @author Joaquin Pega (joaquin.pega@globant.com); Artiom 
 * 
 *
 * @param <T> T Elemento que se va a persistir
 */
public interface GenericDAO<T> {
	/**
	 * Persist a T object
	 * @param t Element to be saved
	 * @throws ObjectDuplicateException	when the object was already saved 
	 */
	public void save(T t) throws ObjectDuplicateException;
	/**
	 * Update a T object already saved
	 * @param t	Element to be updated
	 * @throws ObjectNotFoundException  
	 */
	public void update(T t) throws ObjectNotFoundException;
	/**
	 * Delete a T object
	 * @param t	Element to be deleted
	 * @throws ObjectNotFoundException
	 */
	public void delete(T t)throws ObjectNotFoundException;
	/**
	 * Search by a filter
	 * @param query filter
	 * @return	List of T objects
	 * @throws ObjectNotFoundException
	 */
	public List<T> search(String query)throws ObjectNotFoundException;
	/**
	 * Get all the elements saved
	 * @return	List of T objects
	 * @throws ObjectNotFoundException
	 */
	public List<T> getAll()throws ObjectNotFoundException;
	
}
