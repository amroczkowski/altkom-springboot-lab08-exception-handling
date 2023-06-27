package pl.altkom.springboot.lab08.exceptionhandling.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pl.altkom.springboot.lab08.exceptionhandling.exceptions.DivisorException;

@RestControllerAdvice
public class DefaultControllerAdvice {

//    @ExceptionHandler({DivisorException.class})
//    public ResponseEntity<String> handleDivisorException(final DivisorException e) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You can not divide by zero");
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class,
            MissingRequestHeaderException.class,
            HttpMessageNotReadableException.class})
    public String handleBadRequestException(final Exception e) {
        return String.format("Bad request exception: %s", e.getMessage());
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public String handleUnkownException(final Exception e) {
//        return "Unknown exception";
//    }
}
