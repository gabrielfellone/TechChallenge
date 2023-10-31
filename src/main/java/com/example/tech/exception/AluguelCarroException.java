package com.example.tech.exception;

import java.io.Serial;

public class AluguelCarroException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public AluguelCarroException(String message, Exception e) {super(message, e);}

    public AluguelCarroException(String message) {super(message);}

}
