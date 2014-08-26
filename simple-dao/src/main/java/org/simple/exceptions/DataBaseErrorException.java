package org.simple.exceptions;
/**
 * Unchecked exception of the DAO
 * @author joaquin
 *
 */
public class DataBaseErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataBaseErrorException(String message) {
		super(message);
	}

}
