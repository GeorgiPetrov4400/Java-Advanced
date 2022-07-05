package GenericsExercise.GenericSwapMethodString;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            box.add(input);
        }
        String[] swapIndex = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(swapIndex[0]);
        int secondIndex = Integer.parseInt(swapIndex[1]);
        box.swap(firstIndex, secondIndex);

        System.out.println(box);
    }
}
