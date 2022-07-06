package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.sort(numbers);
        Collections.reverse(numbers);
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (numbers.isEmpty()) {
                break;
            }
            if (count == 3) {
                break;
            }
            System.out.print(numbers.get(i) + " ");
            count++;
            i--;
            numbers.remove(0);
        }
    }
}
