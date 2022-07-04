package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class CustomMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        // System.out.println(Arrays.stream(numbers).min().getAsInt());

        System.out.println(getMinNumber(numbers));
    }

    public static int getMinNumber(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int number : array) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}
