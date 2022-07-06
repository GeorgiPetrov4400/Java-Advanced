package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];
        fillMatrix(scanner, rows, matrix);

        printMainDiagonal(rows, matrix);
        System.out.println();
        printSecondaryDiagonal(rows, matrix);
    }

    private static void printSecondaryDiagonal(int rows, int[][] matrix) {
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[i][j] + " ");
                i--;
            }
        }
    }

    private static void printMainDiagonal(int rows, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
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
