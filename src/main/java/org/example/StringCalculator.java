package org.example;

public class StringCalculator {
    public int calculate(String numbers) {
        if (numbers.isEmpty()) return 0;
        int sum = 0;
        for (String token : numbers.split(",")) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
