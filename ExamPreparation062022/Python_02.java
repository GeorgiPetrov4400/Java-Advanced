package ExamPreparation062022;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Python_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[] commandsInput = scanner.nextLine().split(", ");

        String[][] matrix = new String[matrixSize][matrixSize];
        fillMatrix(scanner, matrixSize, matrix);

        int pythonRow = 0;
        int pythonCol = 0;
        int countAllFood = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].contains("s")) {
                    pythonRow = row;
                    pythonCol = col;
                } else if (matrix[row][col].contains("f")) {
                    countAllFood++;
                }
            }
        }
        ArrayDeque<String> commandQueue = new ArrayDeque<>();
        for (String command : commandsInput) {
            commandQueue.offer(command);
        }

        int pythonLength = 1;
        int eatenFood = 0;
        while (!commandQueue.isEmpty()) {
            switch (commandQueue.pop()) {
                case "left":
                    pythonCol--;
                    if (pythonCol < 0) {
                        pythonCol = matrix[pythonRow].length - 1;
                    }
                    break;
                case "right":
                    pythonCol++;
                    if (pythonCol > matrix[pythonRow].length - 1) {
                        pythonCol = 0;
                    }
                    break;
                case "up":
                    pythonRow--;
                    if (pythonRow < 0) {
                        pythonRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    pythonRow++;
                    if (pythonRow > matrix.length - 1) {
                        pythonRow = 0;
                    }
                    break;
            }
            if (matrix[pythonRow][pythonCol].equals("f")) {
                pythonLength++;
                eatenFood++;
                if (eatenFood == countAllFood) {
                    break;
                }
            } else if (matrix[pythonRow][pythonCol].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }
        if (eatenFood < countAllFood) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", countAllFood - eatenFood);
        } else {
            System.out.printf("You win! Final python length is %d", pythonLength);
        }
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, String[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            String[] matrixElement = scanner.nextLine().split("\\s+");
            matrix[row] = matrixElement;
        }
    }
}
