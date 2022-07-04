package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> addCommand = numList -> numList.stream().map(n -> n + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyCommand = numList -> numList.stream().map(n -> n * 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractCommand = numList -> numList.stream().map(n -> n - 1).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.equals("add")) {
                numbers = addCommand.apply(numbers);
            } else if (command.equals("multiply")) {
                numbers = multiplyCommand.apply(numbers);
            } else if (command.equals("subtract")) {
                numbers = subtractCommand.apply(numbers);
            } else if (command.equals("print")) {
                numbers.forEach(n -> System.out.printf("%d ", n));
//                for (Integer number : numbers) {
//                    System.out.print(number + " ");
//                }
                System.out.println();
            }

            command = scanner.nextLine();
        }
    }
}
