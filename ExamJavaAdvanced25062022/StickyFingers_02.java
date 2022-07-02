package ExamJavaAdvanced25062022;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StickyFingers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[] commandsInput = scanner.nextLine().split(",");

        String[][] matrix = new String[matrixSize][matrixSize];
        fillMatrix(scanner, matrixSize, matrix);

        int dilingerRow = 0;
        int dilingerCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].contains("D")) {
                    dilingerRow = row;
                    dilingerCol = col;
                }
            }
        }
        ArrayDeque<String> commandQueue = new ArrayDeque<>();
        for (String command : commandsInput) {
            commandQueue.offer(command);
        }

        int dilingerCurrentRow = 0;
        int dilingerCurrentCol = 0;
        int sumOfStolenMoney = 0;
        boolean isCaptured = false;

        while (!commandQueue.isEmpty()) {
            dilingerCurrentRow = dilingerRow;
            dilingerCurrentCol = dilingerCol;
            switch (commandQueue.poll()) {
                case "left":
                    dilingerCol--;
                    if (dilingerCol < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        dilingerCol = 0;
                    }
                    if (matrix[dilingerRow][dilingerCol].equals("$")) {
                        int robbedMoney = dilingerRow * dilingerCol;
                        sumOfStolenMoney += robbedMoney;
                        System.out.printf("You successfully stole %d$.%n", robbedMoney);
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "D";
                    } else if (matrix[dilingerRow][dilingerCol].equals("P")) {
                     //   System.out.printf("You got caught with %d$, and you are going to jail.%n", sumOfStolenMoney);
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "#";
                        isCaptured = true;
                        break;
                    } else {
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "D";
                    }
                    break;
                case "right":
                    dilingerCol++;
                    if (dilingerCol > matrix[dilingerRow].length - 1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        dilingerCol = matrix[dilingerRow].length - 1;
                    }
                    if (matrix[dilingerRow][dilingerCol].equals("$")) {
                        int robbedMoney = dilingerRow * dilingerCol;
                        sumOfStolenMoney += robbedMoney;
                        System.out.printf("You successfully stole %d$.%n", robbedMoney);
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "D";
                    } else if (matrix[dilingerRow][dilingerCol].equals("P")) {
                      //  System.out.printf("You got caught with %d$, and you are going to jail.%n", sumOfStolenMoney);
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "#";
                        isCaptured = true;
                        break;
                    } else {
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "D";
                    }
                    break;
                case "up":
                    dilingerRow--;
                    if (dilingerRow < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        dilingerRow = 0;
                    }
                    if (matrix[dilingerRow][dilingerCol].equals("$")) {
                        int robbedMoney = dilingerRow * dilingerCol;
                        sumOfStolenMoney += robbedMoney;
                        System.out.printf("You successfully stole %d$.%n", robbedMoney);
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "D";
                    } else if (matrix[dilingerRow][dilingerCol].equals("P")) {
                     //   System.out.printf("You got caught with %d$, and you are going to jail.%n", sumOfStolenMoney);
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "#";
                        isCaptured = true;
                        break;
                    } else {
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "D";
                    }
                    break;
                case "down":
                    dilingerRow++;
                    if (dilingerRow > matrix.length - 1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        dilingerRow = matrix.length - 1;
                    }
                    if (matrix[dilingerRow][dilingerCol].equals("$")) {
                        int robbedMoney = dilingerRow * dilingerCol;
                        sumOfStolenMoney += robbedMoney;
                        System.out.printf("You successfully stole %d$.%n", robbedMoney);
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "D";
                    } else if (matrix[dilingerRow][dilingerCol].equals("P")) {
                       // System.out.printf("You got caught with %d$, and you are going to jail.%n", sumOfStolenMoney);
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "#";
                        isCaptured = true;
                        break;
                    } else {
                        matrix[dilingerCurrentRow][dilingerCurrentCol] = "+";
                        matrix[dilingerRow][dilingerCol] = "D";
                    }
                    break;
            }
            if (isCaptured) {
                break;
            }
        }
        if (isCaptured) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", sumOfStolenMoney);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", sumOfStolenMoney);
        }
        printMatrix(matrix);
    }

    private static void fillMatrix(Scanner scanner, int matrixRow, String[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
            String[] matrixElement = scanner.nextLine().split("\\s+");
            matrix[row] = matrixElement;
        }
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
