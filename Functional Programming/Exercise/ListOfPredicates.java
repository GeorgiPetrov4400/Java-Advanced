package FunctionalProgrammingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> divisibleNumbers = num -> {
            for (int number : numbers) {
                if (num % number != 0) {
                    return false;
                }
            }
            return true;
        };
        List<Integer> listNumbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (divisibleNumbers.test(i)) {
                listNumbers.add(i);
            }
        }
        for (Integer integer : listNumbers) {
            System.out.printf("%d ", integer);
        }
    }
}
