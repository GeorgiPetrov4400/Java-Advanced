package ExamPreparation062022;

import java.util.Scanner;

public class ReVolt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][matrixSize];
        fillMatrix(scanner, matrixSize, matrix);

        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].contains("f")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        int currentPlayerRow = 0;
        int currentPlayerCol = 0;
        boolean isFinished = false;

        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            currentPlayerRow = playerRow;
            currentPlayerCol = playerCol;

            switch (command) {
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol = matrix[playerRow].length - 1;
                    }
                    if (matrix[playerRow][playerCol].equals("B")) {
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = matrix[playerRow].length - 1;
                        }
                        if (matrix[playerRow][playerCol].equals("F")) {
                            matrix[playerRow][playerCol] = "f";
                            matrix[currentPlayerRow][currentPlayerCol] = "-";
                            isFinished = true;
                            System.out.println();
                            break;
                        } else {
                            matrix[playerRow][playerCol] = "f";
                            matrix[currentPlayerRow][currentPlayerCol] = "-";
                        }
                    } else if (matrix[playerRow][playerCol].equals("T")) {
                        playerCol++;
                        if (playerCol > matrix[playerRow].length - 1) {
                            playerCol = 0;
                        }
                        matrix[playerRow][playerCol] = "f";
                    } else if (matrix[playerRow][playerCol].equals("F")) {
                        matrix[currentPlayerRow][currentPlayerCol] = "-";
                        matrix[playerRow][playerCol] = "f";
                        isFinished = true;
                        break;
                    } else {
                        matrix[currentPlayerRow][currentPlayerCol] = "-";
                        matrix[playerRow][playerCol] = "f";
                        break;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol > matrix[playerRow].length - 1) {
                        playerCol = 0;
                    }
                    if (matrix[playerRow][playerCol].equals("B")) {
                        playerCol++;
                        if (playerCol > matrix[playerRow].length - 1) {
                            playerCol = 0;
                        }
                        if (matrix[playerRow][playerCol].equals("F")) {
                            matrix[playerRow][playerCol] = "f";
                            matrix[currentPlayerRow][currentPlayerCol] = "-";
                            isFinished = true;
                            System.out.println();
                            break;
                        } else {
                            matrix[playerRow][playerCol] = "f";
                            matrix[currentPlayerRow][currentPlayerCol] = "-";
                        }
                    } else if (matrix[playerRow][playerCol].equals("T")) {
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = matrix[playerRow].length - 1;
                        }
                        matrix[playerRow][playerCol] = "f";
                    } else if (matrix[playerRow][playerCol].equals("F")) {
                        matrix[currentPlayerRow][currentPlayerCol] = "-";
                        matrix[playerRow][playerCol] = "f";
                        isFinished = true;
                        break;
                    } else {
                        matrix[currentPlayerRow][currentPlayerCol] = "-";
                        matrix[playerRow][playerCol] = "f";
                        break;
                    }
                    break;
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow = matrix.length - 1;
                    }
                    if (matrix[playerRow][playerCol].equals("B")) {
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = matrix.length - 1;
                        }
                        if (matrix[playerRow][playerCol].equals("F")) {
                            matrix[playerRow][playerCol] = "f";
                            matrix[currentPlayerRow][currentPlayerCol] = "-";
                            isFinished = true;
                            System.out.println();
                            break;
                        } else {
                            matrix[playerRow][playerCol] = "f";
                            matrix[currentPlayerRow][currentPlayerCol] = "-";
                        }
                    } else if (matrix[playerRow][playerCol].equals("T")) {
                        playerRow++;
                        if (playerRow > matrix.length - 1) {
                            playerRow = 0;
                        }
                        matrix[playerRow][playerCol] = "f";
                    } else if (matrix[playerRow][playerCol].equals("F")) {
                        matrix[currentPlayerRow][currentPlayerCol] = "-";
                        matrix[playerRow][playerCol] = "f";
                        isFinished = true;
                        break;
                    } else {
                        matrix[currentPlayerRow][currentPlayerCol] = "-";
                        matrix[playerRow][playerCol] = "f";
                        break;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow > matrix.length - 1) {
                        playerRow = 0;
                    }
                    if (matrix[playerRow][playerCol].equals("B")) {
                        playerRow++;
                        if (playerRow > matrix.length - 1) {
                            playerRow = 0;
                        }
                        if (matrix[playerRow][playerCol].equals("F")) {
                            matrix[playerRow][playerCol] = "f";
                            matrix[currentPlayerRow][currentPlayerCol] = "-";
                            isFinished = true;
                            System.out.println();
                            break;
                        } else {
                            matrix[playerRow][playerCol] = "f";
                            matrix[currentPlayerRow][currentPlayerCol] = "-";
                        }
                    } else if (matrix[playerRow][playerCol].equals("T")) {
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = matrix.length - 1;
                        }
                        matrix[playerRow][playerCol] = "f";
                    } else if (matrix[playerRow][playerCol].equals("F")) {
                        matrix[currentPlayerRow][currentPlayerCol] = "-";
                        matrix[playerRow][playerCol] = "f";
                        isFinished = true;
                        break;
                    } else {
                        matrix[currentPlayerRow][currentPlayerCol] = "-";
                        matrix[playerRow][playerCol] = "f";
                        break;
                    }
            }
            if (isFinished) {
                System.out.println("Player won!");
                break;
            }
        }
        if (!isFinished) {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static void fillMatrix(Scanner scanner, int matrixSize, String[][] matrix) {
        for (int row = 0; row < matrixSize; row++) {
            String[] matrixElement = scanner.nextLine().split("");
            matrix[row] = matrixElement;
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
