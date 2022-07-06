package SetAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int endOfFirstLoop = input[0];
        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < endOfFirstLoop; i++) {
            firstSet.add(scanner.nextLine());
        }

        int endOfSecondLoop = input[1];
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < endOfSecondLoop; i++) {
            secondSet.add(scanner.nextLine());
        }

        firstSet.retainAll(secondSet);
        System.out.println(String.join(" ", firstSet));
    }
}
