package com.in28minutes.rest.webservices.restfulwebservices.exceptions;

// @ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * Eclipse generated
	 */
	private static final long serialVersionUID = 6313511763032109421L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
