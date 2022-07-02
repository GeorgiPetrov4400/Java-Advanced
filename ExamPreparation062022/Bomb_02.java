package ExamPreparation062022;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Bomb_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[] commandInput = scanner.nextLine().split(",");

        String[][] matrix = new String[matrixSize][matrixSize];
        fillMatrix(scanner, matrixSize, matrix);

        int sapperRow = 0;
        int sapperCol = 0;
        int placedBomb = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].contains("s")) {
                    sapperRow = row;
                    sapperCol = col;
                } else if (matrix[row][col].contains("B")) {
                    placedBomb++;
                }
            }
        }
        ArrayDeque<String> commands = new ArrayDeque<>();
        for (String string : commandInput) {
            commands.offer(string);
        }
        int foundBomb = 0;
        while (!commands.isEmpty()) {
            switch (commands.pop()) {
                case "left":
                    if (sapperCol > 0) {
                        sapperCol--;
                    }
                    break;
                case "right":
                    if (sapperCol < matrix.length - 1) {
                        sapperCol++;
                    }
                    break;
                case "up":
                    if (sapperRow > 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow < matrix.length - 1) {
                        sapperRow++;
                    }
                    break;
            }
            if (matrix[sapperRow][sapperCol].contains("B")) {
                System.out.println("You found a bomb!");
                matrix[sapperRow][sapperCol] = "+";
                foundBomb++;
                if (placedBomb == foundBomb) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapperRow][sapperCol].contains("e")) {
                System.out.printf("END! %d bombs left on the field", placedBomb - foundBomb);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", placedBomb - foundBomb, sapperRow, sapperCol);
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, String[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            String[] matrixElement = scanner.nextLine().split("\\s+");
            matrix[row] = matrixElement;
        }
    }
}
