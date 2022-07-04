package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Consumer<String> consumer = System.out::println;

        for (String name : input) {
            consumer.accept("Sir " + name);
        }

        input.stream().forEach(name -> System.out.printf("Sir %s%n", name));
    }
}
