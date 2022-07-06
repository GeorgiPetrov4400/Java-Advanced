package SetAndMapsAdvancedExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> personInfo = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];
            personInfo.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {
            if (personInfo.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, personInfo.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
