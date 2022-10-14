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
    @Test
    public void twoNumberSeparatedByCommaWillReturnThatAdditionNumber() {
        final StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.calculate("1,2"));
        assertEquals(5, calculator.calculate("3,2"));
    }
    @Test
    public void multipleNumberSeparatedByCommaWillReturnThoseAdditionNumber() {
        final StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.calculate("1,2,3,4,5"));
    }
    @Test
    public void multipleNumberSeparatedByNewLineWillReturnThoseAdditionNumber() {
        final StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.calculate("1,2\n3,4\n5"));
    }
    @Test
    public void emptyLinesShouldBeIgnored() {
        final StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.calculate("1,2\n"));
    }

    @Test
    public void multipleNumberSeparatedByCustomDelimiterWillReturnThoseAdditionNumber() {
        final StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.calculate("//;\n1;2\n3;4\n5"));
        assertEquals(15, calculator.calculate("//^\n1^2\n3^4\n5"));
    }
}
