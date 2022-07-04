package FunctionalProgrammingLab;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int begin = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        String command = scanner.nextLine();

        System.out.println(IntStream.rangeClosed(begin, end)
                .boxed()
                .filter(getPredicate(command))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

//        List<Integer> numbers = new ArrayList<>();
//
//        for (int i = begin; i <= end; i++) {
//            numbers.add(i);
//        }
//        String command = scanner.nextLine();
//        switch (command) {
//            case "odd":
//                numbers.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
//                break;
//            case "even":
//                numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
//                break;
//        }
    }

    public static Predicate<Integer> getPredicate(String condition) {
        if (condition.equals("odd")) {
            return n -> n % 2 != 0;
        }
        return n -> n % 2 == 0;
    }
}
