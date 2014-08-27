package org.simple.persistence;

import java.util.List;

import org.simple.exceptions.ObjectDuplicateException;
import org.simple.exceptions.ObjectNotFoundException;
import org.simple.model.Language;

public class LanguageDAO implements GenericDAO<Language> {

	@Override
	public void save(Language t) throws ObjectDuplicateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Language t) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Language t) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Language> search(String query) throws ObjectNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
