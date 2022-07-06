package StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class ALLCAPITALS {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/StreamsFilesAndDirectoriesExercise/input.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("src/StreamsFilesAndDirectoriesExercise/output.txt"))) {
            br.lines().forEach(line -> printWriter.println(line.toUpperCase()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
