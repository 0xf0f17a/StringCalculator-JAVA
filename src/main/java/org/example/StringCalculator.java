package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int calculate(String numbers) {
        if (numbers.isEmpty()) return 0;
        final List<Character> delimiters = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        boolean hadError = false;
        StringBuilder regex = new StringBuilder("[\\n");
        delimiters.add(',');
        if (numbers.startsWith("//")) {
            int i = numbers.indexOf('\n');
            char d = numbers.charAt(i - 1);
            delimiters.add(d);
            numbers = numbers.substring(i + 1);
        }
        for (Character ch : delimiters) {
            regex.append(ch);
        }
        regex.append(']');
        for (String token : numbers.split(regex.toString())) {
            if (token.isBlank()) continue;
            int value = Integer.parseInt(token);
            if (value < 0) {
                hadError = true;
                negatives.add(value);
            }
            if (value <= 1000) {
                sum += value;
            }
        }
        if (hadError) {
            String message = String.format("negatives not allowed: %s", negatives);
            throw new IllegalArgumentException(message);
        }
        return sum;
    }
}
