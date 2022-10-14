package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void negativeNumberThrowsException() {
        final StringCalculator calculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculate("-1")
        );
        assertTrue(exception.getMessage().contains("-1"));
        assertTrue(exception.getMessage().contains("negatives not allowed"));
    }

    @Test
    public void multipleNegativeNumberThrowsExceptionContainingNegativeNumbers() {
        final StringCalculator calculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculate("//^\n-1^2\n-3^-4\n-5")
        );
        String message = exception.getMessage();
        assertTrue(message.contains("-1"));
        assertTrue(message.contains("-3"));
        assertTrue(message.contains("-4"));
        assertTrue(message.contains("-5"));
        assertTrue(message.contains("negatives not allowed"));
    }

    @Test
    public void numbersBiggerThan1000ShouldBeAvoided() {
        final StringCalculator calculator = new StringCalculator();
        assertEquals(13, calculator.calculate("//;\n1;1002\n3;4\n5"));
        assertEquals(1200, calculator.calculate("200,400,600"));
    }

    @Test
    public void numbersSeparatedByMultipleCommasReturnsCorrectResult() {
        final StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.calculate("1,,2\n3,,4\n\n5"));
    }
}
