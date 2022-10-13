package org.example;

public class StringCalculator {
    public int calculate(String numbers) {
        if (numbers.isEmpty()) return 0;
        else return Integer.parseInt(numbers);
    }
}
