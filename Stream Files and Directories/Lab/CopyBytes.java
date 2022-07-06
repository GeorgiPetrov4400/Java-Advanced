package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) {

        String path = "input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

            int read = fileInputStream.read();

            PrintWriter printWriter = new PrintWriter(fileOutputStream);

            while (read != -1) {
                if (read == ' ') {
                    printWriter.print(' ');
                } else if (read == 10) {
                    printWriter.println();
                } else {
                    printWriter.print(read);
                }
                read = fileInputStream.read();
            }
            printWriter.close();
        } catch (IOException ignored) {

        }
    }
}
