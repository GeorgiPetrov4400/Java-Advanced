package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryNumberStack = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.println(0);
            return;
        }
        while (decimalNumber > 0) {
            int binaryNumberElement = decimalNumber % 2;
            binaryNumberStack.push(binaryNumberElement);
            decimalNumber = decimalNumber / 2;
        }

        while (!binaryNumberStack.isEmpty()) {
            System.out.print(binaryNumberStack.pop());
        }
    }
}
