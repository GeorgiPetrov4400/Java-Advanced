package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRow = Integer.parseInt(scanner.nextLine());
        int matrixCol = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[matrixRow][matrixCol];
        fillMatrix(scanner, matrixRow, firstMatrix);
        String[][] secondMatrix = new String[matrixRow][matrixCol];
        fillMatrix(scanner, matrixRow, secondMatrix);

        String[][] thirdMatrix = new String[matrixRow][matrixCol];
        printThirdMatrix(firstMatrix, secondMatrix, thirdMatrix);
    }

    private static void printThirdMatrix(String[][] firstMatrix, String[][] secondMatrix, String[][] thirdMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            String[] firstArray = firstMatrix[row];
            String[] secondArray = secondMatrix[row];
            for (int col = 0; col < firstArray.length; col++) {
                String firstElement = firstArray[col];
                String secondElement = secondArray[col];
                if (firstElement.equals(secondElement)) {
                    thirdMatrix[row][col] = firstElement;
                    System.out.print(firstElement + " ");
                } else {
                    thirdMatrix[row][col] = "*";
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, String[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            String[] matrixElement = scanner.nextLine().split("\\s+");
            matrix[row] = matrixElement;
        }
    }
}
