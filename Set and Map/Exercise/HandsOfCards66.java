package SetAndMapsAdvancedExercise;

import java.util.*;

public class HandsOfCards66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> nameAndCards = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] data = input.split(": ");
            String name = data[0];
            String cards = data[1];
            if (nameAndCards.containsKey(name)) {
                nameAndCards.get(name).add(cards);
            } else {
                nameAndCards.put(name, new HashSet<>());
                nameAndCards.get(name).add(cards);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : nameAndCards.entrySet()) {
            System.out.printf("%s: ", entry.getKey());
            Set<String> cardsSet = new HashSet<>();
            for (String cards : entry.getValue()) {
                String[] cardInfo = cards.split(", ");
                for (int i = 0; i < cardInfo.length; i++) {
                    cardsSet.add(cardInfo[i]);
                }
            }
            int sum = 0;
            for (String element : cardsSet) {
                String[] singleElement = element.split("");
                String firstElement = singleElement[0];
                String secondElement = singleElement[1];
                int firstElementNumber = 0;
                switch (firstElement) {
                    case "2":
                        firstElementNumber = 2;
                        break;
                    case "3":
                        firstElementNumber = 3;
                        break;
                    case "4":
                        firstElementNumber = 4;
                        break;
                    case "5":
                        firstElementNumber = 5;
                        break;
                    case "6":
                        firstElementNumber = 6;
                        break;
                    case "7":
                        firstElementNumber = 7;
                        break;
                    case "8":
                        firstElementNumber = 8;
                        break;
                    case "9":
                        firstElementNumber = 9;
                        break;
                    case "10":
                        firstElementNumber = 10;
                        break;
                    case "J":
                        firstElementNumber = 11;
                        break;
                    case "Q":
                        firstElementNumber = 12;
                        break;
                    case "K":
                        firstElementNumber = 13;
                        break;
                    case "A":
                        firstElementNumber = 14;
                        break;
                }
                int secondElementNumber = 0;
                switch (secondElement) {
                    case "S":
                        secondElementNumber = 4;
                        break;
                    case "H":
                        secondElementNumber = 3;
                        break;
                    case "D":
                        secondElementNumber = 2;
                        break;
                    case "C":
                        secondElementNumber = 1;
                        break;
                }
                int multipliedResult = firstElementNumber * secondElementNumber;
                sum += multipliedResult;
            }
            System.out.printf("%d%n", sum);
        }
    }
}
