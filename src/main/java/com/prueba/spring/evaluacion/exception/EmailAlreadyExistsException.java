package com.prueba.spring.evaluacion.exception;

public class EmailAlreadyExistsException extends Exception {
	
    /**
     * Creates a new instance of <code>EmailAlreadyExistsException</code>
     * without detail message.
     */
    public EmailAlreadyExistsException() {
    }

    /**
     * Constructs an instance of <code>EmailAlreadyExistsException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public EmailAlreadyExistsException(String msg) {
        super(msg);
    }
}
