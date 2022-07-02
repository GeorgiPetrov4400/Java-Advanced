package ExamPreparation062022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlaning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tasksInput = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> threadsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        for (Integer integer : tasksInput) {
            tasksStack.push(integer);
        }

        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        for (Integer integer : threadsInput) {
            threadsQueue.offer(integer);
        }

        int taskToKill = Integer.parseInt(scanner.nextLine());

        int currentTask = 0;
        int currentThread = 0;
        while (!tasksStack.isEmpty()) {
            if (threadsQueue.isEmpty()) {
                break;
            }

            currentTask = tasksStack.peek();
            currentThread = threadsQueue.peek();
            if (currentTask == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", threadsQueue.peek(), taskToKill);
                break;
            }
            if (currentThread >= currentTask) {
                tasksStack.poll();
                threadsQueue.pop();
            } else {
                threadsQueue.pop();
            }
        }

        for (Integer integer : threadsQueue) {
            System.out.print(integer + " ");
        }
    }
}
