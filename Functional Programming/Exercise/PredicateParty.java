package FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] data = input.split("\\s+");
            String command = data[0];
            Predicate<String> predicate = getPredicate(data);
            if (command.equals("Double")) {
                List<String> doubleNames = new ArrayList<>();
                for (String name : names) {
                    if (predicate.test(name)) {
                        doubleNames.add(name);
                    }
                }
                names.addAll(doubleNames);
//                names.stream().filter(predicate).forEach(person -> doubleNames.add(person));
//                names.addAll(doubleNames);
//                names.forEach(System.out::println);
            } else if (command.equals("Remove")) {
                names.removeIf(predicate);
            }

            input = scanner.nextLine();
        }
        Collections.sort(names);
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String print = String.join(", ", names) + " are going to the party!";
            System.out.println(print);
        }
    }

    public static Predicate<String> getPredicate(String[] data) {
        Predicate<String> predicate = null;
        String condition = data[1];
        String criteria = data[2];
        if (condition.equals("StartsWith")) {
            predicate = name -> name.startsWith(criteria);
        } else if (condition.equals("EndsWith")) {
            predicate = name -> name.endsWith(criteria);
        } else if (condition.equals("Length")) {
            predicate = name -> name.length() == Integer.parseInt(criteria);
        }
        return predicate;
    }
}
