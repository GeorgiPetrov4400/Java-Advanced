package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses75 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> firstHalfStack = new ArrayDeque<>();
        ArrayDeque<String> secondHalfStack = new ArrayDeque<>();

        if (input.length() % 2 == 0) {
            boolean isBalanced = false;
            for (int i = 0; i < input.length() / 2; i++) {
                char symbol = input.charAt(i);
                firstHalfStack.push(String.valueOf(symbol));
            }
            for (int i = input.length() - 1; i > input.length() / 2 - 1; i--) {
                char symbol = input.charAt(i);
                secondHalfStack.push(String.valueOf(symbol));
            }
            while (!firstHalfStack.isEmpty() && !secondHalfStack.isEmpty()) {
                String firstSymbol = firstHalfStack.poll();
                String secondSymbol = secondHalfStack.poll();
                if (firstSymbol.equals("(") && secondSymbol.equals(")")) {
                    isBalanced = true;
                } else if (firstSymbol.equals("{") && secondSymbol.equals("}")) {
                    isBalanced = true;
                } else if (firstSymbol.equals("[") && secondSymbol.equals("]")) {
                    isBalanced = true;
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
        } else {
            System.out.println("NO");
        }
    }
}
