package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> countNumbers = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            double currentNumber = numbers[i];
            if (countNumbers.containsKey(currentNumber)) {
                int match = countNumbers.get(currentNumber);
                countNumbers.put(currentNumber, match + 1);
            } else {
                countNumbers.put(currentNumber, 1);
            }
        }
        for (var entry : countNumbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
