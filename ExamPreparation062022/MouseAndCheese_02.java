package ExamPreparation062022;

import java.util.Scanner;

public class MouseAndCheese_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][matrixSize];
        fillMatrix(scanner, matrixSize, matrix);

        int mouseRow = 0;
        int mouseCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].contains("M")) {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }
        int currentRow = 0;
        int currentCol = 0;
        int cheeseEaten = 0;

        String command = scanner.nextLine();
        boolean isOutOfBounds = false;
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    currentRow = mouseRow;
                    currentCol = mouseCol;
                    matrix[currentRow][currentCol] = "-";
                    mouseRow--;
                    if (mouseRow < 0) {
                        mouseRow = 0;
                        matrix[mouseRow][mouseCol] = "-";
                        isOutOfBounds = true;
                        break;
                    }
                    if (matrix[mouseRow][mouseCol].contains("c")) {
                        cheeseEaten++;
                        matrix[mouseRow][mouseCol] = "M";
                    } else if (matrix[mouseRow][mouseCol].contains("B")) {
                        matrix[mouseRow][mouseCol] = "-";
                        mouseRow--;
                        if (matrix[mouseRow][mouseCol].contains("c")) {
                            cheeseEaten++;
                            matrix[mouseRow][mouseCol] = "M";
                        } else {
                            matrix[mouseRow][mouseCol] = "M";
                        }
                    } else {
                        matrix[mouseRow][mouseCol] = "M";
                    }
                    break;
                case "down":
                    currentRow = mouseRow;
                    currentCol = mouseCol;
                    matrix[currentRow][currentCol] = "-";
                    mouseRow++;
                    if (mouseRow >= matrix.length) {
                        mouseRow = matrix.length - 1;
                        matrix[mouseRow][mouseCol] = "-";
                        isOutOfBounds = true;
                        break;
                    }
                    if (matrix[mouseRow][mouseCol].contains("c")) {
                        cheeseEaten++;
                        matrix[mouseRow][mouseCol] = "M";
                    } else if (matrix[mouseRow][mouseCol].contains("B")) {
                        matrix[mouseRow][mouseCol] = "-";
                        mouseRow++;
                        if (matrix[mouseRow][mouseCol].contains("c")) {
                            cheeseEaten++;
                            matrix[mouseRow][mouseCol] = "M";
                        } else {
                            matrix[mouseRow][mouseCol] = "M";
                        }
                    } else {
                        matrix[mouseRow][mouseCol] = "M";
                    }
                    break;
                case "left":
                    currentRow = mouseRow;
                    currentCol = mouseCol;
                    matrix[currentRow][currentCol] = "-";
                    mouseCol--;
                    if (mouseCol < 0) {
                        mouseCol = 0;
                        matrix[mouseRow][mouseCol] = "-";
                        isOutOfBounds = true;
                        break;
                    }
                    if (matrix[mouseRow][mouseCol].contains("c")) {
                        cheeseEaten++;
                        matrix[mouseRow][mouseCol] = "M";
                    } else if (matrix[mouseRow][mouseCol].contains("B")) {
                        matrix[mouseRow][mouseCol] = "-";
                        mouseCol--;
                        if (matrix[mouseRow][mouseCol].contains("c")) {
                            cheeseEaten++;
                            matrix[mouseRow][mouseCol] = "M";
                        } else {
                            matrix[mouseRow][mouseCol] = "M";
                        }
                    } else {
                        matrix[mouseRow][mouseCol] = "M";
                    }
                    break;
                case "right":
                    currentRow = mouseRow;
                    currentCol = mouseCol;
                    matrix[currentRow][currentCol] = "-";
                    mouseCol++;
                    if (mouseCol >= matrix[currentRow].length) {
                        mouseCol = matrix.length - 1;
                        matrix[mouseRow][mouseCol] = "-";
                        isOutOfBounds = true;
                        break;
                    }
                    if (matrix[mouseRow][mouseCol].contains("c")) {
                        cheeseEaten++;
                        matrix[mouseRow][mouseCol] = "M";
                    } else if (matrix[mouseRow][mouseCol].contains("B")) {
                        matrix[mouseRow][mouseCol] = "-";
                        mouseCol++;
                        if (matrix[mouseRow][mouseCol].contains("c")) {
                            cheeseEaten++;
                            matrix[mouseRow][mouseCol] = "M";
                        } else {
                            matrix[mouseRow][mouseCol] = "M";
                        }
                    } else {
                        matrix[mouseRow][mouseCol] = "M";
                    }
                    break;
            }
            if (isOutOfBounds) {
                break;
            }

            command = scanner.nextLine();
        }

        if (isOutOfBounds) {
            System.out.println("Where is the mouse?");
        }
        if (cheeseEaten >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        }
        printMatrix(matrix);

    }

    private static void fillMatrix(Scanner scanner, int matrixRow, String[][] matrix) {
        for (int row = 0; row < matrixRow; row++) {
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
