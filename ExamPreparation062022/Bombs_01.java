package ExamPreparation062022;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstBombEffectInput = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> lastBombCasingInput = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> firstBombEffectQueue = new ArrayDeque<>();
        for (Integer integer : firstBombEffectInput) {
            firstBombEffectQueue.offer(integer);
        }

        ArrayDeque<Integer> lastBombCasingStack = new ArrayDeque<>();
        for (Integer integer : lastBombCasingInput) {
            lastBombCasingStack.push(integer);
        }

        int countDaturaBombs = 0;
        int countCherryBombs = 0;
        int countSmokeBombs = 0;
        boolean isFillTheBombPouch = false;

        while (!firstBombEffectQueue.isEmpty()) {
            if (lastBombCasingStack.isEmpty()) {
                break;
            }
            int firstBombNum = firstBombEffectQueue.peek();
            int secondBombNum = lastBombCasingStack.peek();
            int sumFirstAndSecondNum = firstBombNum + secondBombNum;
            switch (sumFirstAndSecondNum) {
                case 40:
                    countDaturaBombs++;
                    firstBombEffectQueue.pop();
                    lastBombCasingStack.poll();
                    break;
                case 60:
                    countCherryBombs++;
                    firstBombEffectQueue.pop();
                    lastBombCasingStack.poll();
                    break;
                case 120:
                    countSmokeBombs++;
                    firstBombEffectQueue.pop();
                    lastBombCasingStack.poll();
                    break;
                default:
                    int currentSecondBombNum = lastBombCasingStack.poll();
                    lastBombCasingStack.push(currentSecondBombNum - 5);
                    break;
            }
            if (countDaturaBombs >= 3 && countCherryBombs >= 3 && countSmokeBombs >= 3) {
                isFillTheBombPouch = true;
                break;
            }

        }
        if (isFillTheBombPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (firstBombEffectQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            List<String> result = new ArrayList<>();
            for (Integer integer : firstBombEffectQueue) {
                result.add(integer + "");
            }
            System.out.println(String.join(", ", result));
        }

        if (lastBombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            List<String> result = new ArrayList<>();
            for (Integer integer : lastBombCasingStack) {
                result.add(integer + "");
            }
            System.out.println(String.join(", ", result));
        }

        System.out.printf("Cherry Bombs: %d%n", countCherryBombs);
        System.out.printf("Datura Bombs: %d%n", countDaturaBombs);
        System.out.printf("Smoke Decoy Bombs: %d%n", countSmokeBombs);
    }
}
