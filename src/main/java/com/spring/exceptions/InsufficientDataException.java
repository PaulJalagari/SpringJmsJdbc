package com.spring.exceptions;

public class InsufficientDataException extends RuntimeException {
    
    /**
     * 
     */
    private static final long serialVersionUID = 462683926442911220L;

    private  String message;
    
    public static final String INSUFFICIENT_DATA="Data not sufficient to fulfill the  request";
	
	public InsufficientDataException(String message) {
		super();
		this.message = message;
	}



	public InsufficientDataException() {

		super();
		message = INSUFFICIENT_DATA;
	}


	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return message;
	}


}
