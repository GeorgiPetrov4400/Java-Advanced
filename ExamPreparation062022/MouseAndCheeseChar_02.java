package ExamPreparation062022;

import java.util.Scanner;

public class MouseAndCheeseChar_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        int mouseRow = 0;
        int mouseCol = 0;
        for (int i = 0; i < matrixSize; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("M")) {
                mouseRow = i;
                mouseCol = line.indexOf("M");
            }
        }
        fillCharMatrix(matrix);

        String command = scanner.nextLine();

        int eatenCheese = 0;
        int currentMouseRow = 0;
        int currentMouseCol = 0;

        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    currentMouseRow = mouseRow;
                    currentMouseCol = mouseCol;
                    mouseRow--;

                    if (matrix[mouseRow][mouseCol] == 'c') {
                        eatenCheese++;
                    }

                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }


            command = scanner.nextLine();
        }
    }

    private static void fillCharMatrix(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.println(c);
            }
            System.out.println();
        }
    }
}
