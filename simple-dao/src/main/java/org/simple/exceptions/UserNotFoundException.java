package org.simple.exceptions;
/**
 * Checked exception of the DAO
 * @author joaquin
 *
 */
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String arg0) {
		super(arg0);
	}

}
