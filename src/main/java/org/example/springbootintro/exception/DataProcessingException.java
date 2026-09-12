package org.example.springbootintro.exception;

public class DataProcessingException extends RuntimeException {
    public DataProcessingException(String massage, Throwable t) {
        super(massage, t);
    }
}
