package ExamPreparation062022;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> freshnessLevelInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        for (Integer integer : ingredientsInput) {
            ingredientsQueue.offer(integer);
        }

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        for (Integer integer : freshnessLevelInput) {
            freshnessStack.push(integer);
        }
        int sumToMix = 0;
        int countPearSour = 0;
        int countTheHarvest = 0;
        int countAppleHinny = 0;
        int countHighFashion = 0;

        while (!ingredientsQueue.isEmpty()) {
            if (freshnessStack.isEmpty()) {
                break;
            }
            int ingredientsNumber = ingredientsQueue.peek();
            int freshnessNumber = freshnessStack.peek();

            if (ingredientsNumber == 0) {
                ingredientsQueue.pop();
                continue;
            } else {
                sumToMix = ingredientsNumber * freshnessNumber;
            }
            switch (sumToMix) {
                case 150:
                    countPearSour++;
                    ingredientsQueue.pop();
                    freshnessStack.poll();
                    break;
                case 250:
                    countTheHarvest++;
                    ingredientsQueue.pop();
                    freshnessStack.poll();
                    break;
                case 300:
                    countAppleHinny++;
                    ingredientsQueue.pop();
                    freshnessStack.poll();
                    break;
                case 400:
                    countHighFashion++;
                    ingredientsQueue.pop();
                    freshnessStack.poll();
                    break;
                default:
                    freshnessStack.poll();
                    int currentIngredient = ingredientsQueue.pop();
                    ingredientsQueue.offer(currentIngredient + 5);
                    break;
            }
        }
        if (countPearSour >= 1 && countTheHarvest >= 1 && countAppleHinny >= 1 && countHighFashion >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sumOfLeftIngredients = 0;
        if (!ingredientsQueue.isEmpty()) {
            for (Integer integer : ingredientsQueue) {
                sumOfLeftIngredients += integer;
            }
            System.out.printf("Ingredients left: %d%n", sumOfLeftIngredients);
        }

        Map<String, Integer> coctailMap = new TreeMap<>();
        if (countAppleHinny > 0) {
            coctailMap.put("Apple Hinny", countAppleHinny);
        }
        if (countPearSour > 0) {
            coctailMap.put("Pear Sour", countPearSour);
        }
        if (countTheHarvest > 0) {
            coctailMap.put("The Harvest", countTheHarvest);
        }
        if (countHighFashion > 0) {
            coctailMap.put("High Fashion", countHighFashion);
        }
        for (Map.Entry<String, Integer> entry : coctailMap.entrySet()) {
            System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
