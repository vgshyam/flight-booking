package com.airway.security.exception;

/**
 * @Author Shyam Jul 31, 2021 10:45:42 PM
 */

public class GeneralException extends RuntimeException {

	private static final long serialVersionUID = -887922317632736028L;

	/**
	 * default constructor
	 */
	public GeneralException() {
		super();
	}

	/**
	 * @param message
	 */
	public GeneralException(String message) {
		super(message);
	}

}