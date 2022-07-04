package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minNumber = (int[] array) -> {
            int min = Integer.MAX_VALUE;
            int minElementIndex = 0;
            for (int i = 0; i < array.length; i++) {
                int element = array[i];
                if (element <= min) {
                    min = element;
                    minElementIndex = i;
                }
            }
            return minElementIndex;
        };
        System.out.println(minNumber.apply(numbers).toString());
        //   System.out.println(getSmallestElementIndex(numbers));
    }

//    public static int getSmallestElementIndex(int[] array) {
//        int min = Integer.MAX_VALUE;
//        int minElementIndex = 0;
//        for (int i = 0; i < array.length; i++) {
//            int element = array[i];
//            if (element < min) {
//                min = element;
//                minElementIndex = i;
//            }
//        }
//        return minElementIndex;
//
//    }
}

