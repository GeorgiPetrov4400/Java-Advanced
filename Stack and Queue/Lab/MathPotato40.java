package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());

            if (cycle >= 2) {
                if (isPrime(cycle)) {
                    ArrayDeque<String> queuePrintPrime = new ArrayDeque<>(queue);
                    while (queuePrintPrime.size() > 0) {
                        System.out.println("Prime " + queuePrintPrime.poll());
                    }
                    System.out.println("Removed " + queue.poll());
                } else {
                    System.out.println("Removed " + queue.poll());
                }
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());

    }

    private static boolean isPrime(int cycle) {
        int count = 0;
        for (int i = 1; i <= cycle; i++) {
            if (cycle % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }
}
