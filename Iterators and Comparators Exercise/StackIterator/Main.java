package IteratorsAndComparatorsExercise.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Stack currentStack = new Stack();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+|,\\s+");
            switch (data[0]) {
                case "Push":
                    currentStack.push(Arrays.copyOfRange(data, 1, data.length));
                    break;
                case "Pop":
                    try {
                        currentStack.pop();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        Stack.print(currentStack);
        Stack.print(currentStack);
    }
}
