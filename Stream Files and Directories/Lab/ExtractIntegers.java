package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(fileInputStream);

        PrintWriter printWriter = new PrintWriter(new FileOutputStream("output-integers.txt"));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printWriter.println(scanner.next());
            } else {
                scanner.next();
            }
        }
        printWriter.close();
    }
}
