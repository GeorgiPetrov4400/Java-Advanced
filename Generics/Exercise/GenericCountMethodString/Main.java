package GenericsExercise.GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            box.add(input);
        }
        String element = scanner.nextLine();
        int number = box.countGreaterElement(element);
        System.out.println(number);
    }
}
