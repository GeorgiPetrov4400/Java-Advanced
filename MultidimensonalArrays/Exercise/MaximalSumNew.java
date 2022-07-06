package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSumNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int matrixRows = input[0];
        int matrixCols = input[1];

        int[][] matrix = new int[matrixRows][matrixCols];
        fillMatrix(scanner, matrixRows, matrix);

        int maxSum = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int row = 0; row < matrixRows - 2; row++) {
            for (int col = 0; col < matrixCols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = bestRow; row < bestRow + 3; row++) {
            for (int col = bestCol; col < bestCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, int[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            int[] matrixElement = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = matrixElement;
        }
    }
}
