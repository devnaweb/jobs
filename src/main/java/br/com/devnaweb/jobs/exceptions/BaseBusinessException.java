package br.com.devnaweb.jobs.exceptions;

import org.springframework.http.HttpStatus;

public class BaseBusinessException extends Exception {
    private final HttpStatus status;
    private final boolean printStack;
    private String message;

    public BaseBusinessException(final HttpStatus httpStatus, final String message, final boolean printStack) {
        this.status = httpStatus;
        this.message = message;
        this.printStack = printStack;
    }
}
