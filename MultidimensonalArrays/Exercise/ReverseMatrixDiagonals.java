package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int matrixRows = input[0];
        int matrixCols = input[1];
        String[][] matrix = new String[matrixRows][matrixCols];
        fillMatrix(scanner, matrixRows, matrix);

        List<List<Integer>> reverseDiagonal = new ArrayList<>();
        for (int i = 0; i < matrixRows + matrixCols - 1; i++) {
            reverseDiagonal.add(new ArrayList<>());
        }
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixCols; j++) {
                reverseDiagonal.get(matrixRows + matrixCols - 2 - (i + j))
                        .add(0, Integer.valueOf(matrix[i][j]));
            }
        }
        for (List<Integer> integers : reverseDiagonal) {
            for (Integer number : integers) {
                System.out.println(number);
                reverseDiagonal.get(number).remove(number);
                break;
            }
        }
        System.out.println();
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, String[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            String[] matrixElement = scanner.nextLine().split("\\s+");
            matrix[row] = matrixElement;
        }
    }
}
