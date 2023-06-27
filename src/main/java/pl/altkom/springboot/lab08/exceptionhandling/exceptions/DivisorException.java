package pl.altkom.springboot.lab08.exceptionhandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DivisorException extends RuntimeException {

    public DivisorException(final String message) {
        super(message);
    }
}
