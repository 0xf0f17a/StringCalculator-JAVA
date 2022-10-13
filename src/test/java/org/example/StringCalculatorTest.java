package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void emptyStringReturns0() {
        final StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.calculate(""));
    }
    @Test
    public void singleNumberWillReturnThatNumber() {
        final StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.calculate("1"));
        assertEquals(2, calculator.calculate("2"));
        assertEquals(3, calculator.calculate("3"));
    }
}
