package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        fillMatrix(scanner, n, matrix);

        System.out.println(Math.abs(sumMainDiagonal(n, matrix) - sumSecondaryDiagonal(n, matrix)));
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, int[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            int[] matrixElement = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = matrixElement;
        }
    }

    private static int sumMainDiagonal(int rows, int[][] matrix) {
        int sumMainDiagonal = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == j) {
                    sumMainDiagonal += matrix[i][j];
                }
            }
        }
        return sumMainDiagonal;
    }

    private static int sumSecondaryDiagonal(int rows, int[][] matrix) {
        int sumSecondaryDiagonal = 0;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                sumSecondaryDiagonal += matrix[i][j];
                i--;
            }
        }
        return sumSecondaryDiagonal;
    }
}
