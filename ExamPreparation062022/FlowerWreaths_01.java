package ExamPreparation062022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> liliesInput = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> rosesInput = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        for (Integer integer : liliesInput) {
            liliesStack.push(integer);
        }
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        for (Integer integer : rosesInput) {
            rosesQueue.offer(integer);
        }
        int wreaths = 0;
        int leftFlowers = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int lily = liliesStack.poll();
            int rose = rosesQueue.pop();
            int sumForWreaths = lily + rose;
            while (sumForWreaths > 15) {
                lily -= 2;
                sumForWreaths = lily + rose;
            }
            if (sumForWreaths == 15) {
                wreaths++;
            } else {
                leftFlowers += sumForWreaths;
            }
        }
        int wreathFromLeftFlowers = leftFlowers / 15;
        int totalWreaths = wreaths + wreathFromLeftFlowers;
        if (totalWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", totalWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - totalWreaths);
        }
    }
}
