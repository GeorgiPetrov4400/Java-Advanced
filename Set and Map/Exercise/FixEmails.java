package SetAndMapsAdvancedExercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> nameAndMail = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String mail = scanner.nextLine();
            if (mail.endsWith(".us") || mail.endsWith(".uk") || mail.endsWith(".com")) {
                input = scanner.nextLine();
                continue;
            } else {
                nameAndMail.put(input, mail);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : nameAndMail.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
