package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split("\\s+");

        int matrixRow = Integer.parseInt(matrixDimensions[0]);
        int matrixCol = Integer.parseInt(matrixDimensions[1]);

        int[][] firstMatrix = new int[matrixRow][matrixCol];
        for (int row = 0; row < matrixRow; row++) {
            int[] matrixElement = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            firstMatrix[row] = matrixElement;
        }
        String[] matrixDimensions2 = scanner.nextLine().split("\\s+");

        int matrixRow2 = Integer.parseInt(matrixDimensions2[0]);
        int matrixCol2 = Integer.parseInt(matrixDimensions2[1]);
        int[][] secondMatrix = new int[matrixRow2][matrixCol2];
        for (int row = 0; row < matrixRow; row++) {
            int[] matrixElement = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            secondMatrix[row] = matrixElement;
        }
        if (matrixRow == matrixRow2 && matrixCol == matrixCol2) {
            boolean isEqual = false;
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firstArray = firstMatrix[row];
                int[] secondArray = secondMatrix[row];
                for (int col = 0; col < firstArray.length; col++) {
                    int firstElement = firstArray[col];
                    int secondElement = secondArray[col];
                    if (firstElement == secondElement) {
                        isEqual = true;
                    } else {
                        System.out.println("not equal");
                        isEqual = false;
                        return;
                    }
                }
            }
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
