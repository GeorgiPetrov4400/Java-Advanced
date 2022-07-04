package FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            people.add(person);
        }
        String conditionFilter = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String outputPrint = scanner.nextLine();

        people = filterByAge(people, getPredicate(conditionFilter, ageLimit));

        Consumer<Person> printer = getPrinter(outputPrint);
        people.forEach(printer);
    }

    private static Consumer<Person> getPrinter(String outputPrint) {
        switch (outputPrint) {
            case "name":
                return person -> System.out.println(person.name);
            case "age":
                return person -> System.out.println(person.age);
            case "name age":
        }
        return person -> System.out.println(person.name + " - " + person.age);
    }

    private static Predicate<Person> getPredicate(String conditionFilter, int ageLimit) {
        switch (conditionFilter) {
            case "younger":
                return person -> person.age <= ageLimit;
        }
        return person -> person.age >= ageLimit;
    }

    public static List<Person> filterByAge(List<Person> people, Predicate<Person> predicate) {
        return people.stream().filter(predicate).collect(Collectors.toList());
    }
}
