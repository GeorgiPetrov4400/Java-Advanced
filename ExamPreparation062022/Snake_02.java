package ExamPreparation062022;

import java.util.Scanner;

public class Snake_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][matrixSize];
        fillMatrix(scanner, matrixSize, matrix);

        int snakeRow = 0;
        int snakeCol = 0;
        int firstRowB = 0;
        int firstColB = 0;
        int secondRowB = 0;
        int secondColB = 0;
        int countFoundB = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].contains("S")) {
                    snakeRow = row;
                    snakeCol = col;
                } else if (matrix[row][col].contains("B")) {
                    countFoundB++;
                    if (countFoundB == 1) {
                        firstRowB = row;
                        firstColB = col;
                    } else if (countFoundB == 2) {
                        secondRowB = row;
                        secondColB = col;
                    }
                }
            }
        }
        String command = scanner.nextLine();

        int currentRow = 0;
        int currentCol = 0;
        int countEatenFood = 0;
        boolean isOutOfBounds = false;

        while (countEatenFood < 10) {
            currentRow = snakeRow;
            currentCol = snakeCol;
            if (command.equals("left")) {
                snakeCol--;
                if (snakeCol < 0) {
                    isOutOfBounds = true;
                    matrix[currentRow][currentCol] = ".";
                    break;
                }
                if (matrix[snakeRow][snakeCol].equals("*")) {
                    countEatenFood++;
                    if (countEatenFood == 10) {
                        matrix[currentRow][currentCol] = ".";
                        matrix[snakeRow][snakeCol] = "S";
                        break;
                    }
                } else if (matrix[snakeRow][snakeCol].equals("B")) {
                    if (snakeRow == firstRowB && snakeCol == firstColB) {
                        matrix[firstRowB][firstColB] = ".";
                        snakeRow = secondRowB;
                        snakeCol = secondColB;
                    } else if (snakeRow == secondRowB && snakeCol == secondColB) {
                        matrix[secondRowB][secondColB] = ".";
                        snakeRow = firstRowB;
                        snakeCol = firstColB;
                    }
                }
                matrix[currentRow][currentCol] = ".";
                matrix[snakeRow][snakeCol] = "S";

            } else if (command.equals("right")) {
                snakeCol++;
                if (snakeCol > matrix[snakeRow].length - 1) {
                    isOutOfBounds = true;
                    matrix[currentRow][currentCol] = ".";
                    break;
                }
                if (matrix[snakeRow][snakeCol].equals("*")) {
                    countEatenFood++;
                    if (countEatenFood == 10) {
                        matrix[currentRow][currentCol] = ".";
                        matrix[snakeRow][snakeCol] = "S";
                        break;
                    }
                } else if (matrix[snakeRow][snakeCol].equals("B")) {
                    if (snakeRow == firstRowB && snakeCol == firstColB) {
                        matrix[firstRowB][firstColB] = ".";
                        snakeRow = secondRowB;
                        snakeCol = secondColB;
                    } else if (snakeRow == secondRowB && snakeCol == secondColB) {
                        matrix[secondRowB][secondColB] = ".";
                        snakeRow = firstRowB;
                        snakeCol = firstColB;
                    }
                }
                matrix[currentRow][currentCol] = ".";
                matrix[snakeRow][snakeCol] = "S";

            } else if (command.equals("up")) {
                snakeRow--;
                if (snakeRow < 0) {
                    isOutOfBounds = true;
                    matrix[currentRow][currentCol] = ".";
                    break;
                }
                if (matrix[snakeRow][snakeCol].equals("*")) {
                    countEatenFood++;
                    if (countEatenFood == 10) {
                        matrix[currentRow][currentCol] = ".";
                        matrix[snakeRow][snakeCol] = "S";
                        break;
                    }
                } else if (matrix[snakeRow][snakeCol].equals("B")) {
                    if (snakeRow == firstRowB && snakeCol == firstColB) {
                        matrix[firstRowB][firstColB] = ".";
                        snakeRow = secondRowB;
                        snakeCol = secondColB;
                    } else if (snakeRow == secondRowB && snakeCol == secondColB) {
                        matrix[secondRowB][secondColB] = ".";
                        snakeRow = firstRowB;
                        snakeCol = firstColB;
                    }
                }
                matrix[currentRow][currentCol] = ".";
                matrix[snakeRow][snakeCol] = "S";

            } else if (command.equals("down")) {
                snakeRow++;
                if (snakeRow > matrix.length - 1) {
                    isOutOfBounds = true;
                    matrix[currentRow][currentCol] = ".";
                    break;
                }
                if (matrix[snakeRow][snakeCol].equals("*")) {
                    countEatenFood++;
                    if (countEatenFood == 10) {
                        matrix[currentRow][currentCol] = ".";
                        matrix[snakeRow][snakeCol] = "S";
                        break;
                    }
                } else if (matrix[snakeRow][snakeCol].equals("B")) {
                    if (snakeRow == firstRowB && snakeCol == firstColB) {
                        matrix[firstRowB][firstColB] = ".";
                        snakeRow = secondRowB;
                        snakeCol = secondColB;
                    } else if (snakeRow == secondRowB && snakeCol == secondColB) {
                        matrix[secondRowB][secondColB] = ".";
                        snakeRow = firstRowB;
                        snakeCol = firstColB;
                    }
                }
                matrix[currentRow][currentCol] = ".";
                matrix[snakeRow][snakeCol] = "S";
            }

            command = scanner.nextLine();
        }
        if (isOutOfBounds) {
            System.out.println("Game over!");
        }
        if (countEatenFood == 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", countEatenFood);
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
