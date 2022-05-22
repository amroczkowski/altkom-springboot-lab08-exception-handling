package pl.altkom.springboot.lab08.exceptionhandling.exceptions;

public class DivisorException extends RuntimeException {

    public DivisorException(final String message) {
        super(message);
    }
}
