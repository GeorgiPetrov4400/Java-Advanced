package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] queueNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int queueSize = numbers[0];
        int queuePopElement = numbers[1];
        int containElement = numbers[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int number : queueNumbers) {
            queue.offer(number);
        }

        for (int i = 0; i < queuePopElement; i++) {
            queue.poll();
        }

        if (queue.contains(containElement)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
