package org.simple.exceptions;


/**
 * 
 * @author Joaquin Pega
 * 
 *
 */

public class CouldNotFinishOperationException extends RuntimeException{

	
	private static final long serialVersionUID = -388627623605099318L;

	/**
	 * 
	 * @param arg0
	 */
	public CouldNotFinishOperationException(String arg0) {
		super(arg0);
	}
	
}
