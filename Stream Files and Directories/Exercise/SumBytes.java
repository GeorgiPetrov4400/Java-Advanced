package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/StreamsFilesAndDirectoriesExercise/input.txt"))) {
            String line = br.readLine();
            long sum = 0;
            while (line != null) {
                char[] character = line.toCharArray();
                for (int i = 0; i < character.length; i++) {
                    sum += character[i];
                }

                line = br.readLine();
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
