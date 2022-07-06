package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/StreamsFilesAndDirectoriesExercise/input.txt"))) {
            String line = br.readLine();
            while (line != null) {
                int sum = 0;
                char[] character = line.toCharArray();
                for (int i = 0; i < character.length; i++) {
                    sum += character[i];
                }
                System.out.println(sum);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
