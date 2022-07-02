package ExamPreparation062022;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> liquidsInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> liquidQueue = new ArrayDeque<>();
        for (Integer integer : liquidsInput) {
            liquidQueue.offer(integer);
        }

        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();
        for (Integer integer : ingredientsInput) {
            ingredientStack.push(integer);
        }
        int countBread = 0;
        int countCake = 0;
        int countPastry = 0;
        int countFruitPie = 0;

        while (!ingredientStack.isEmpty()) {
            if (liquidQueue.isEmpty()) {
                break;
            }
            int sumOfMixedValues = liquidQueue.peek() + ingredientStack.peek();
            switch (sumOfMixedValues) {
                case 25:
                    countBread++;
                    liquidQueue.pop();
                    ingredientStack.poll();
                    break;
                case 50:
                    countCake++;
                    liquidQueue.pop();
                    ingredientStack.poll();
                    break;
                case 75:
                    countPastry++;
                    liquidQueue.pop();
                    ingredientStack.poll();
                    break;
                case 100:
                    countFruitPie++;
                    liquidQueue.pop();
                    ingredientStack.poll();
                    break;
                default:
                    liquidQueue.pop();
                    int currentIngredient = ingredientStack.pop();
                    ingredientStack.push(currentIngredient + 3);
                    break;
            }
        }
        if (countBread >= 1 && countCake >= 1 && countPastry >= 1 && countFruitPie >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            List<String> result = new ArrayList<>();
            for (Integer integer : liquidQueue) {
                result.add(integer + "");
            }
            System.out.println(String.join(", ", result));
        }

        if (ingredientStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            List<String> result = new ArrayList<>();
            for (Integer integer : ingredientStack) {
                result.add(integer + "");
            }
            System.out.println(String.join(", ", result));
        }
        System.out.printf("Bread: %d%n", countBread);
        System.out.printf("Cake: %d%n", countCake);
        System.out.printf("Fruit Pie: %d%n", countFruitPie);
        System.out.printf("Pastry: %d%n", countPastry);
    }
}
