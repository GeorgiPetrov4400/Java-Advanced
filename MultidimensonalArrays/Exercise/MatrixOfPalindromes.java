package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int matrixRows = input[0];
        int matrixCols = input[1];

        String[][] matrix = new String[matrixRows][matrixCols];
        char firstAndLastChar = 'a';
        char middle = 'a';
        StringBuilder palindrome = new StringBuilder();
        for (int rows = 0; rows < matrixRows; rows++) {
            for (int cols = 0; cols < matrixCols; cols++) {
                palindrome.delete(0, palindrome.length() + 1);
                palindrome.append(firstAndLastChar);
                palindrome.append(middle);
                palindrome.append(firstAndLastChar);
                matrix[rows][cols] = palindrome.toString();
                middle++;
            }
            firstAndLastChar++;
            palindrome.setLength(0);
            middle = firstAndLastChar;
        }
        printMatrix(matrix);
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
