package DefiningClassesExercise.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int age = Integer.parseInt(input[1]);
            Person person = new Person();
            if (age > 30) {
                person.setName(input[0]);
                person.setAge(age);
                personList.add(person);
            }
        }
        personList.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
    }
}
