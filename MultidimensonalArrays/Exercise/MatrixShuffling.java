package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int matrixRows = Integer.parseInt(input[0]);
        int matrixCols = Integer.parseInt(input[1]);

        String[][] matrix = new String[matrixRows][matrixCols];
        fillMatrix(scanner, matrixRows, matrix);

        String data = scanner.nextLine();

        while (!data.equals("END")) {
            input = data.split("\\s+");
            if (input.length == 5) {
                String command = input[0];
                int indexCurrentRow = Integer.parseInt(input[1]);
                int indexCurrentCol = Integer.parseInt(input[2]);
                int indexReplaceRow = Integer.parseInt(input[3]);
                int indexReplaceCol = Integer.parseInt(input[4]);
                if (command.equals("swap")) {
                    if (indexCurrentRow < 0 || indexCurrentCol < 0 || indexReplaceRow < 0 || indexReplaceCol < 0
                            || indexCurrentRow > matrixRows || indexCurrentCol > matrixCols || indexReplaceRow > matrixRows
                            || indexReplaceCol > matrixCols) {
                        System.out.println("Invalid input!");
                    } else {
                        String currentElement = matrix[indexCurrentRow][indexCurrentCol];
                        String replaceElement = matrix[indexReplaceRow][indexReplaceCol];
                        matrix[indexCurrentRow][indexCurrentCol] = replaceElement;
                        matrix[indexReplaceRow][indexReplaceCol] = currentElement;
                        printMatrix(matrix);
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            data = scanner.nextLine();
        }
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, String[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            String[] matrixElement = scanner.nextLine().split("\\s+");
            matrix[row] = matrixElement;
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
