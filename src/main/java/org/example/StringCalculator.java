package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int calculate(String numbers) {
        if (numbers.isEmpty()) return 0;
        final List<Character> delimiters = new ArrayList<>();
        delimiters.add(',');
        if (numbers.startsWith("//")) {
            int i = numbers.indexOf('\n');
            char d = numbers.charAt(i - 1);
            delimiters.add(d);
            numbers = numbers.substring(i + 1);
        }
        String regex = buildRegex(delimiters);
        return calculateSum(numbers, regex);
    }

    private String buildRegex(List<Character> delimiters) {
        StringBuilder regex = new StringBuilder("[\\n");
        for (Character ch : delimiters) {
            regex.append(ch);
        }
        regex.append(']');
        return regex.toString();
    }

    private int calculateSum(String numbers, String delimiters) {
        int sum = 0;
        boolean hadError = false;
        List<Integer> negatives = new ArrayList<>();
        for (String token : numbers.split(delimiters)) {
            int value = Integer.parseInt(token);
            if (value < 0) {
                hadError = true;
                negatives.add(value);
            }
            sum += value;
        }
        if (hadError) {
            String message = String.format("negatives not allowed: %s", negatives);
            throw new IllegalArgumentException(message);
        }
        return sum;
    }
}
