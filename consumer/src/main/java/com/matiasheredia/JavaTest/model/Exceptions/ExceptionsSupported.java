package com.matiasheredia.JavaTest.model.Exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;

public enum ExceptionsSupported {
    INVALID_EMAIL(InvalidFormatException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    INVALID_MESSAGE(InvalidFormatException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    MESSAGE_NOT_NULL(NullPointerException.class, HttpStatus.UNPROCESSABLE_ENTITY);
    private  Class<? extends Throwable> exceptionClass;
    private HttpStatus status;
    private ExceptionsSupported(Class<? extends Throwable> exception, HttpStatus status) {
        this.exceptionClass = exception;
        this.status = status;
    }
    public Class<? extends Throwable> getExceptionClass() {
        return this.exceptionClass;
    }
    public HttpStatus getStatus() {
        return this.status;
    }
}