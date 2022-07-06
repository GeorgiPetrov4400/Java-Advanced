package SetAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] text = scanner.nextLine().toCharArray();

        Map<Character, Integer> symbolsCount = new TreeMap<>();
        for (int i = 0; i < text.length; i++) {
            char symbol = text[i];
            if (symbolsCount.containsKey(symbol)) {
                int currentCount = symbolsCount.get(symbol);
                symbolsCount.put(symbol, currentCount + 1);
            } else {
                symbolsCount.put(symbol, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : symbolsCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
