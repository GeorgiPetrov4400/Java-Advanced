package SetAndMapsAdvancedExercise;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> setOfElements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < input.length; j++) {
                setOfElements.add(input[j]);
            }
        }
        for (String element : setOfElements) {
            System.out.print(element + " ");
        }
    }
}
