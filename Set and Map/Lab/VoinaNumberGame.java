package SetsAndMapsAdvancedLab;

import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int count = 0;
        while (!firstPlayerCards.isEmpty() || !secondPlayerCards.isEmpty()) {
            count++;
            if (count == 50) {
                break;
            }
            Iterator<Integer> firstIterator = firstPlayerCards.iterator();
            int firstCard = firstIterator.next();
            firstPlayerCards.remove(firstCard);

            Iterator<Integer> secondIterator = secondPlayerCards.iterator();
            int secondCard = secondIterator.next();
            secondPlayerCards.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayerCards.add(firstCard);
                secondPlayerCards.add(secondCard);
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
