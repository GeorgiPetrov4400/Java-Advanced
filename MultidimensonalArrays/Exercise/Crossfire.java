package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int matrixRows = Integer.parseInt(input[0]);
        int matrixCols = Integer.parseInt(input[1]);

        int[][] matrix = new int[matrixRows][matrixCols];
        fillMatrix(matrixRows, matrixCols, matrix);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            int rowIndex = Integer.parseInt(command.split("\\s+")[0]);
            int colIndex = Integer.parseInt(command.split("\\s+")[1]);
            int radius = Integer.parseInt(command.split("\\s+")[2]);
            for (int row = rowIndex - radius; row <= rowIndex + radius; row++) {
                if (row >= 0 && row < matrixRows) {
                    matrix[row][colIndex] = 0;
                }
            }
            for (int col = colIndex - radius; col <= colIndex + radius; col++) {
                if (col >= 0 && col < matrixRows) {
                    matrix[rowIndex][col] = 0;
                }
            }

            command = scanner.nextLine();
        }
        List<Integer> matrixRowList = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int element = matrix[row][col];
                if (element != 0) {
                    matrixRowList.add(element);
                }
            }
            int listSize = matrixRowList.size();
            int count = 0;
            for (int i = 0; i < listSize; i++) {
                count++;
                if (count > listSize) {
                    break;
                }
                int element = matrixRowList.get(i);
                System.out.print(element + " ");
                matrixRowList.remove(0);
                i--;
            }
            System.out.println();

        }
    }

    private static void fillMatrix(int matrixRows, int matrixCols, int[][] matrix) {
        int count = 1;
        for (int row = 0; row < matrixRows; row++) {
            for (int col = 0; col < matrixCols; col++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }
}
