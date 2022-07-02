package ExamPreparation062022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstBoxInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondBoxInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        for (Integer integer : firstBoxInput) {
            firstBoxQueue.offer(integer);
        }

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        for (Integer integer : secondBoxInput) {
            secondBoxStack.push(integer);
        }

        int sumClaimedItems = 0;
        while (!firstBoxQueue.isEmpty()) {
            if (secondBoxStack.isEmpty()) {
                System.out.println("Second magic box is empty.");
                break;
            }
            int claimedItem = firstBoxQueue.peek() + secondBoxStack.peek();
            if (claimedItem % 2 == 0) {
                sumClaimedItems += claimedItem;
                firstBoxQueue.pop();
                secondBoxStack.poll();
            } else {
                int removedSecondBoxElement = secondBoxStack.poll();
                firstBoxQueue.offer(removedSecondBoxElement);
            }
        }
        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }

        if (sumClaimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", sumClaimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d%n", sumClaimedItems);
        }
    }
}
