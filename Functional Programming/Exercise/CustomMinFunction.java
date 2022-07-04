package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> function = arr -> Arrays.stream(arr).min().getAsInt();

        System.out.println(function.apply(numbers));

//        Function<int[], Integer> minNumber = (int[] array) -> {
//            int min = Integer.MAX_VALUE;
//            for (int number : array) {
//                if (number < min) {
//                    min = number;
//                }
//            }
//            return min;
//        };
//        System.out.println(minNumber.apply(numbers));
    }
}
