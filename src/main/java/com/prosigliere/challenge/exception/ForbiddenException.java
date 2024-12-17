package com.prosigliere.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -5686076157698191341L;

    /**
     * Constructs a <code>ForbiddenException</code> with the specified message.
     *
     * @param errorCode
     *            the detail message.
     */
    public ForbiddenException(String errorCode) {
        super(errorCode);
    }

    /**
     * Constructs a {@code ForbiddenException} with the specified message and root cause.
     *
     * @param errorCode
     *            the detail message.
     * @param t
     *            root cause
     */
    public ForbiddenException(String errorCode, Throwable t) {
        super(errorCode, t);
    }
}