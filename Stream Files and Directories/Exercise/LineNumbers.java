package StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/StreamsFilesAndDirectoriesExercise/inputLineNumbers.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("src/StreamsFilesAndDirectoriesExercise/output.txt"))) {

            String line = bufferedReader.readLine();
            int countLine = 1;
            while (line != null) {
                printWriter.printf("%d. ",countLine);
                printWriter.print(line);
                printWriter.println();
                countLine++;

                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
