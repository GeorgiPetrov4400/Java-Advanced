package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileToOutput {
    public static void main(String[] args) {
        String path = "input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

            int read = fileInputStream.read();

            while (read != -1) {
                fileOutputStream.write(read);
                //   System.out.print(Integer.toBinaryString(read) + " ");
                read = fileInputStream.read();
            }
        } catch (IOException ignored) {

        }
    }
}
