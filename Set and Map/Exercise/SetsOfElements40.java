package SetAndMapsAdvancedExercise;

import java.util.*;

public class SetsOfElements40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set = new LinkedHashSet<>();
        int endOfFirstLoop = input[0];
        int endOfSecondLoop = input[1];

        for (int i = 0; i < endOfFirstLoop; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            set.add(number);
        }
        for (int i = 0; i < endOfSecondLoop; i++) {
            int number2 = Integer.parseInt(scanner.nextLine());
            if (set.contains(number2)){
                System.out.print(number2 + " ");
            }
        }
    }
}
