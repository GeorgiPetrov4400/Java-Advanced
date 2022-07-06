package MultidimensionalArraysLab;

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(", ");

        int matrixRow = Integer.parseInt(matrixDimensions[0]);
        int matrixCol = Integer.parseInt(matrixDimensions[1]);

        String[][] matrix = new String[matrixRow][matrixCol];
        fillMatrix(scanner, matrixRow, matrix);

        int sum = 0;
        for (String[] row : matrix) {
            for (String element : row) {
                sum += Integer.parseInt(element);
            }
        }
        System.out.println(matrixRow);
        System.out.println(matrixCol);
        System.out.println(sum);
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, String[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            String[] matrixElement = scanner.nextLine().split(", ");
            matrix[row] = matrixElement;
        }
    }
}
