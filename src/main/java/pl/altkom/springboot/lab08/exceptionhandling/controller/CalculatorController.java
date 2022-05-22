package pl.altkom.springboot.lab08.exceptionhandling.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.altkom.springboot.lab08.exceptionhandling.exceptions.DivisorException;
import pl.altkom.springboot.lab08.exceptionhandling.service.CalculatorService;

@RequiredArgsConstructor
@RequestMapping("/calculator")
@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/add/a/{a}/b/{b}")
    public Float add(@PathVariable("a") final Float a, @PathVariable("b") final Float b) {
        return calculatorService.add(a, b);
    }

    @GetMapping("/subtract/a/{a}/b/{b}")
    public Float subtract(@PathVariable("a") final Float a, @PathVariable("b") final Float b) {
        return calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply/a/{a}/b/{b}")
    public Float multiply(@PathVariable("a") final Float a, @PathVariable("b") final Float b,
            @RequestHeader("username") final String userName) {
        return calculatorService.multiply(a, b);
    }

    @GetMapping("/divide/a/{a}/b/{b}")
    public Float divide(@PathVariable("a") final Float a, @PathVariable("b") final Float b) {
        return calculatorService.divide(a, b);
    }

    @ExceptionHandler({DivisorException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDivisorException(final DivisorException e) {
        return "You can't divide by zero";
    }
}
