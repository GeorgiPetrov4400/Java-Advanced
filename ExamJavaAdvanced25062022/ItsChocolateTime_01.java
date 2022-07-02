package ExamJavaAdvanced25062022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ItsChocolateTime_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> milkInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());

        List<Double> cacaoPowderInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        for (Double value : milkInput) {
            milkQueue.offer(value);
        }

        ArrayDeque<Double> cacaoPowderStack = new ArrayDeque<>();
        for (Double value : cacaoPowderInput) {
            cacaoPowderStack.push(value);
        }

        int milkChocolate = 0;
        int darkChocolate = 0;
        int bakingChocolate = 0;

        while (!milkQueue.isEmpty()) {
            if (cacaoPowderStack.isEmpty()) {
                break;
            }
            double currentMilkValue = milkQueue.peek();
            double currentCacaoPowderValue = cacaoPowderStack.peek();
            double sumOfIngredients = currentMilkValue + currentCacaoPowderValue;
            double cacaoPercentage = currentCacaoPowderValue / sumOfIngredients * 100;
            if (cacaoPercentage == 30) {
                milkChocolate++;
                milkQueue.pop();
                cacaoPowderStack.poll();
            } else if (cacaoPercentage == 50) {
                darkChocolate++;
                milkQueue.pop();
                cacaoPowderStack.poll();
            } else if (cacaoPercentage == 100) {
                bakingChocolate++;
                milkQueue.pop();
                cacaoPowderStack.poll();
            } else {
                cacaoPowderStack.poll();
                double currentMilk = milkQueue.pop();
                milkQueue.offer(currentMilk + 10);
            }
        }
        if (milkChocolate >= 1 && darkChocolate >= 1 && bakingChocolate >= 1) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        if (bakingChocolate != 0) {
            System.out.printf("# Baking Chocolate --> %d%n", bakingChocolate);
        }
        if (darkChocolate != 0) {
            System.out.printf("# Dark Chocolate --> %d%n", darkChocolate);
        }
        if (milkChocolate != 0) {
            System.out.printf("# Milk Chocolate --> %d%n", milkChocolate);
        }
    }
}
