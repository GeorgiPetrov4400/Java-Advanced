package GenericsExercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String command = data[0];
            switch (command) {
                case "Add":
                    String elementToAdd = data[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(data[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String elementToMatch = data[1];
                    System.out.println(customList.contains(elementToMatch));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(data[1]);
                    int secondIndex = Integer.parseInt(data[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elementToCheck = data[1];
                    System.out.println(customList.countGreaterElement(elementToCheck));
                    break;
                case "Max":
                    System.out.println(customList.max());
                    break;
                case "Min":
                    System.out.println(customList.min());
                    break;
                case "Print":
                    System.out.println(customList.toString());
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
