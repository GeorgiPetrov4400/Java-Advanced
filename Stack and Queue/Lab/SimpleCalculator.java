package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> calculatorInput = new ArrayDeque<>();

        Collections.addAll(calculatorInput, input);

        while (calculatorInput.size() > 1) {
            int firstNum = Integer.parseInt(calculatorInput.pop());
            String operation = calculatorInput.pop();
            int secondNum = Integer.parseInt(calculatorInput.pop());

            int result = 0;
            switch (operation) {
                case "+":
                    result = firstNum + secondNum;
                    calculatorInput.push(String.valueOf(result));
                    break;
                case "-":
                    result = firstNum - secondNum;
                    calculatorInput.push(String.valueOf(result));
                    break;
            }
        }
        System.out.println(calculatorInput.pop());
    }
}

