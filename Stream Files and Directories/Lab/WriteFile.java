package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        String path = "input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

            int read = fileInputStream.read();

            while (read != -1) {
                char symbol = (char) read;
                if (symbol != ',' && symbol != '.' && symbol != '!' && symbol != '?') {
                    fileOutputStream.write(read);
                }
                read = fileInputStream.read();
            }
        } catch (IOException ignored) {

        }
    }
}
