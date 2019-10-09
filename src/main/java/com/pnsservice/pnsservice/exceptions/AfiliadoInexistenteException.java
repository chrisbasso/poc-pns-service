package com.pnsservice.pnsservice.exceptions;

import okhttp3.internal.http2.ErrorCode;
import org.springframework.http.HttpStatus;

public class AfiliadoInexistenteException extends Exception{

    private final HttpStatus httpStatus;

    public AfiliadoInexistenteException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
