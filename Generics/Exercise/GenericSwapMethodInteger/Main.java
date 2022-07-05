package GenericsExercise.GenericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Integer> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            box.add(input);
        }
        String[] swapIndex = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(swapIndex[0]);
        int secondIndex = Integer.parseInt(swapIndex[1]);
        box.swap(firstIndex, secondIndex);

        System.out.println(box);
    }
}
