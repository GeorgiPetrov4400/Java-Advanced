package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(", ");

        int matrixRow = Integer.parseInt(matrixDimensions[0]);
        int matrixCol = Integer.parseInt(matrixDimensions[1]);

        int[][] matrix = new int[matrixRow][matrixCol];
        fillMatrix(scanner, matrixRow, matrix);

        int maxSum = Integer.MIN_VALUE;
        int[][] biggestMatrix = new int[2][2];

        for (int row = 0; row < matrixRow - 1; row++) {
            for (int col = 0; col < matrixCol - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    biggestMatrix = new int[][]{
                            {matrix[row][col], matrix[row][col + 1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}
                    };
                }
            }
        }
        printMatrix(biggestMatrix);
        System.out.println(maxSum);
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, int[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            int[] matrixElement = Arrays.stream(scanner.nextLine().split(", "))
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
