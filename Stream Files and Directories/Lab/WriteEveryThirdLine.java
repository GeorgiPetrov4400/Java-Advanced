package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output-every-third-line.txt"));

        String line = bufferedReader.readLine();
        int count = 0;
        while (line != null) {
            count++;
            if (count % 3 == 0) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            line = bufferedReader.readLine();
        }
        bufferedWriter.close();
    }
}
