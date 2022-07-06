package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        fillMatrix(scanner, rows, matrix);

        int[][] updateMatrix = new int[rows][matrix[0].length];
        int[] wrongValueIndex = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int row = wrongValueIndex[0];
        int col = wrongValueIndex[1];
        int wrongValue = matrix[row][col];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    updateMatrix[i][j] = ((j == 0 ? 0 : matrix[i][j - 1] == wrongValue ? 0 : matrix[i][j - 1]) +
                            (j == matrix[i].length - 1 ? 0 : matrix[i][j + 1] == wrongValue ? 0 : matrix[i][j + 1]) +
                            (i == 0 ? 0 : matrix[i - 1][j] == wrongValue ? 0 : matrix[i - 1][j]) +
                            (i == rows - 1 ? 0 : matrix[i + 1][j] == wrongValue ? 0 : matrix[i + 1][j]));
                } else {
                    updateMatrix[i][j] = matrix[i][j];
                }
            }
        }
        printMatrix(updateMatrix);
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, int[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            int[] matrixElement = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = matrixElement;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
