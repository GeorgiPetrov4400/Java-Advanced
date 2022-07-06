package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesesEdit75 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> firstHalfStack = new ArrayDeque<>();
        ArrayDeque<Character> secondHalfStack = new ArrayDeque<>();

        boolean isBalanced = false;
        for (int i = 0; i < input.length() / 2; i++) {
            char symbol = input.charAt(i);
            firstHalfStack.push(symbol);
        }
        for (int i = input.length() - 1; i > input.length() / 2 - 1; i--) {
            char symbol = input.charAt(i);
            secondHalfStack.push(symbol);
            if (input.length() % 2 != 0 && symbol == 32) {
                secondHalfStack.poll();
            }
        }
        while (!firstHalfStack.isEmpty() && !secondHalfStack.isEmpty()) {
            char firstSymbol = firstHalfStack.poll();
            char secondSymbol = secondHalfStack.poll();
            if (firstSymbol == 40 && secondSymbol == 41) {
                isBalanced = true;
            } else if (firstSymbol == 123 && secondSymbol == 125) {
                isBalanced = true;
            } else if (firstSymbol == 91 && secondSymbol == 93) {
                isBalanced = true;
            } else if (firstSymbol == 32 && secondSymbol == 32) {
                continue;
            } else {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
