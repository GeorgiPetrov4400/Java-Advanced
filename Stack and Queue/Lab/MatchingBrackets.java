package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == 40) {
                stack.push(String.valueOf(i));
            } else if (symbol == 41) {
                int startIndex = Integer.parseInt(stack.pop());
                String expression = input.substring(startIndex, i + 1);
                System.out.println(expression);
            }
        }
    }
}
