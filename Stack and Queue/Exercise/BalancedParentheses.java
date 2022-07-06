package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> openingParentheses = new ArrayDeque<>();

        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char currentParentheses = input.charAt(i);
            if (currentParentheses == '(' || currentParentheses == '[' || currentParentheses == '{') {
                openingParentheses.push(currentParentheses);
            } else {
                if (openingParentheses.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpeningParentheses = openingParentheses.pop();
                if (currentParentheses == ')' && lastOpeningParentheses != '(') {
                    isBalanced = false;
                    break;
                } else if (currentParentheses == ']' && lastOpeningParentheses != '[') {
                    isBalanced = false;
                    break;
                } else if (currentParentheses == '}' && lastOpeningParentheses != '{') {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
