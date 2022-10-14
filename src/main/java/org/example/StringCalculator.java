package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int calculate(String numbers) {
        if (numbers.isEmpty()) return 0;
        final List<String> delimiters = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        StringBuilder regex = new StringBuilder("[\\n");
        delimiters.add(",");
        if (numbers.startsWith("//")) {
            int i = numbers.indexOf('\n');
            String d;
            if (numbers.charAt(2) == '[') {
                d = numbers.substring(3, i - 1);
            } else {
                d = numbers.substring(i - 1, i);
            }
            delimiters.add(d);
            numbers = numbers.substring(i + 1);
        }
        for (String ch : delimiters) {
            regex.append(ch);
        }
        regex.append(']');
        for (String token : numbers.split(regex.toString())) {
            if (token.isBlank()) continue;
            int value = Integer.parseInt(token);
            if (value < 0) {
                negatives.add(value);
            }
            if (value <= 1000) {
                sum += value;
            }
        }
        if (!negatives.isEmpty()) {
            String message = String.format("negatives not allowed: %s", negatives);
            throw new IllegalArgumentException(message);
        }
        return sum;
    }
}
