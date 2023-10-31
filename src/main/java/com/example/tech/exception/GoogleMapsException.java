package com.example.tech.exception;

import java.io.Serial;

public class GoogleMapsException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public GoogleMapsException(String message, Exception e) {super(message, e);}

    public GoogleMapsException(String message) {super(message);}

}
