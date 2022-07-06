package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountCharacterTypes {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/StreamsFilesAndDirectoriesExercise/input.txt"))) {

            String line = bufferedReader.readLine();
            int vowels = 0;
            int punctuation = 0;
            int consonant = 0;
            while (line != null) {
                char[] characterOfLine = line.toCharArray();

                for (char symbol : characterOfLine) {
                    if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                        vowels++;
                    } else if (symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?') {
                        punctuation++;
                    } else if (symbol == ' ') {
                        continue;
                    } else {
                        consonant++;
                    }
                }

                line = bufferedReader.readLine();
            }
            System.out.printf("Vowels: %d%n", vowels);
            System.out.printf("Consonants: %d%n", consonant);
            System.out.printf("Punctuation: %d%n", punctuation);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
