package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] stackNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int stackSize = numbers[0];
        int stackPopElement = numbers[1];
        int containElement = numbers[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int number : stackNumbers) {
            stack.push(number);
        }

        for (int i = 0; i < stackPopElement; i++) {
            stack.pop();
        }

        if (stack.contains(containElement)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
