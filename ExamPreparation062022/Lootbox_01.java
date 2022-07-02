package ExamPreparation062022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lootbox_01 {
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
                System.out.println("Second lootbox is empty");
                break;
            }

            int firstBoxNumber = firstBoxQueue.peek();
            int secondBoxNumber = secondBoxStack.peek();
            int sumNumbers = firstBoxNumber + secondBoxNumber;
            if (sumNumbers % 2 == 0) {
                sumClaimedItems += sumNumbers;
                firstBoxQueue.pop();
                secondBoxStack.poll();
            } else {
                int lastItemSecondBox = secondBoxStack.poll();
                firstBoxQueue.offer(lastItemSecondBox);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (sumClaimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sumClaimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sumClaimedItems);
        }
    }
}
