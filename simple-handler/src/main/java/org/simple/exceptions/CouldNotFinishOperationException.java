package org.simple.exceptions;


/**
 * 
 * @author Joaquin Pega ; Artiom Amerhanov (artiom.amerhanov@globant.com)
 * 
 *
 */

public class CouldNotFinishOperationException extends RuntimeException{

	
	private static final long serialVersionUID = -388627623605099318L;

	/**
	 * 
	 * @param arg0 message of the exception
	 */
	public CouldNotFinishOperationException(String arg0) {
		super(arg0);
	}
	
}
