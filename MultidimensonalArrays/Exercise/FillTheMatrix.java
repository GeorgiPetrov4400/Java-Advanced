package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int matrixRow = Integer.parseInt(input[0]);
        String matrixType = input[1];

        int[][] matrix = new int[matrixRow][matrixRow];
        int count = 1;
        switch (matrixType) {
            case "A":
                for (int col = 0; col < matrixRow; col++) {
                    for (int row = 0; row < matrixRow; row++) {
                        matrix[row][col] = count;
                        count++;
                    }
                }
                break;
            case "B":
                for (int col = 0; col < matrixRow; col++) {
                    if (col % 2 != 0) {
                        for (int row = matrixRow - 1; row >= 0; row--) {
                            matrix[row][col] = count;
                            count++;
                        }
                    } else {
                        for (int row = 0; row < matrixRow; row++) {
                            matrix[row][col] = count;
                            count++;
                        }
                    }
                }
                break;
        }
        printMatrix(matrix);
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
