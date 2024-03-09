package edu.sharif.demo;

import jakarta.websocket.server.PathParam;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/sum")
    public String getSum(@PathParam("augend") float augend, @PathParam("addend") float addend) {
        return calculatorService.addition(augend, addend);
    }

    @GetMapping("/sub")
    public float getSub(@PathVariable int minuend, @PathVariable int subtrahend) {
        return calculatorService.subtraction(minuend, subtrahend);
    }

    @GetMapping("/mul")
    public float getMul(@PathVariable int multiplicand, @PathVariable int multiplier) {
        return calculatorService.multiplication(multiplicand, multiplier);
    }

    @GetMapping("/div")
    public float getDiv(@PathParam("dividend") int dividend, @PathParam("divisor") int divisor) throws BadRequestException {
        return calculatorService.division(dividend, divisor);
    }
}
