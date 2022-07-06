package IteratorsAndComparatorsExercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> personList = new ArrayList<>();

        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];

            Person person = new Person(name, age, town);
            personList.add(person);

            input = scanner.nextLine();
        }
        int comparePersonIndex = Integer.parseInt(scanner.nextLine());
        Person personToCompare = personList.get(comparePersonIndex - 1);

        int totalPerson = personList.size();
        int samePerson = 0;
        int differentPerson = 0;

        for (Person person : personList) {
            if (person.compareTo(personToCompare) == 0) {
                samePerson++;
            } else {
                differentPerson++;
            }
        }
        if (samePerson == 1) {
            System.out.println("No matches");
        } else {
            System.out.print(samePerson + " " + differentPerson + " " + totalPerson);
        }
    }
}
