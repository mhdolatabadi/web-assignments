package edu.sharif.demo;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String addition(float augend, float addend) {
        float sum = augend + addend;
        return String.format("%.2f + %.2f = %.2f", augend, addend, sum);
    }

    public float subtraction(float minuend, float subtrahend) {
        return minuend - subtrahend;
    }

    public float multiplication(float multiplicand, float multiplier) {
        return multiplicand * multiplier;
    }

    public float division(float dividend, float divisor) throws BadRequestException {
        try {
            return dividend / divisor;
        } catch (RuntimeException e) {
            throw new BadRequestException("invalid input", e);
        }
    }
}
