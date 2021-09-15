package br.com.quarkus.exception;

public class ApiRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -9204783576304003824L;

    public ApiRuntimeException(String message) {
        super(message);
    }
}