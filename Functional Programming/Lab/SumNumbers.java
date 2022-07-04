package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, String> count = list -> "Count = " + list.size();
        Function<List<Integer>, Integer> sumNumbers = list -> list.stream().mapToInt(n -> n).sum();
        Function<Integer, String> sumNumbersString = sum -> "Sum = " + sum;

        String countOutput = count.apply(input);

        System.out.println(countOutput);

        int sum = sumNumbers.apply(input);
        String sumOutput = sumNumbersString.apply(sum);
        System.out.println(sumOutput);
    }
}
