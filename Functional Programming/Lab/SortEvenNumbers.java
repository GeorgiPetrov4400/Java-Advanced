package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        printNumbers(input);
        System.out.println();
        Collections.sort(input);
        printNumbers(input);
    }

    private static void printNumbers(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            int number = input.get(i);
            if (i == input.size() - 1) {
                System.out.print(number);
            } else {
                System.out.print(number + ", ");
            }
        }
    }
}
