package pl.altkom.springboot.lab08.exceptionhandling.service;

import org.springframework.stereotype.Service;

import pl.altkom.springboot.lab08.exceptionhandling.exceptions.DivisorException;

@Service
public class CalculatorService {

    public Float add(final Float a, final Float b) {
        return a + b;
    }

    public Float subtract(final Float a, final Float b) {
        return a - b;
    }

    public Float multiply(final Float a, final Float b) {
        return a * b;
    }

    public Float divide(final Float a, final Float b) {

        if (b == 0.0) {
            throw new DivisorException("Dividing by zero is wrong!");
        }

        return a / b;
    }
}
