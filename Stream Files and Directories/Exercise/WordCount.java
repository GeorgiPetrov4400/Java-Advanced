package StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class WordCount {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/StreamsFilesAndDirectoriesExercise/words.txt"));
        BufferedReader matchingText = new BufferedReader(new FileReader("src/StreamsFilesAndDirectoriesExercise/text.txt"));
             PrintWriter printWriter = new PrintWriter("src/StreamsFilesAndDirectoriesExercise/result.txt")) {

            String[] wordToFind = bufferedReader.readLine().split("\\s+");
            String firstWord = wordToFind[0];
            String secondWord = wordToFind[1];
            String thirdWord = wordToFind[2];

            int countFirstWord = 0;
            int countSecondWord = 0;
            int countThirdWord = 0;
            String line = matchingText.readLine();
            while (line != null){
                String[] data = line.split("\\s+");
                for (String match : data) {
                    if (match.equals(firstWord)) {
                        countFirstWord++;
                    } else if (match.equals(secondWord)){
                        countSecondWord++;
                    } else if (match.equals(thirdWord)) {
                        countThirdWord++;
                    }
                }
                
                line = matchingText.readLine();
            }
            printWriter.println(firstWord + " - " + countFirstWord);
            printWriter.println(secondWord + " - " + countSecondWord);
            printWriter.println(thirdWord + " - " + countThirdWord);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
