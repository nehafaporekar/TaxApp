package com.taxapp.exception;

/**
 * @author 10614376
 * Custom Exception for Tax Application
 *
 */
public class ApplicationException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7936621742926583312L;

	/**
	 * Non Parameterized constructor
	 */
	public ApplicationException() {
		super();
	}
	
	/**
	 * One Parameterized constructor
	 */
	public ApplicationException(String message) {
		super(message);
	}
	
	/**
	 * Two Parameterized constructor
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
