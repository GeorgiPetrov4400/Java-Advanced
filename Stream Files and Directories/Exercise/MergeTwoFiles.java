package StreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) {
        Path input1 = Paths.get("src/StreamsFilesAndDirectoriesExercise/inputOne.txt");
        Path input2 = Paths.get("src/StreamsFilesAndDirectoriesExercise/inputTwo.txt");
        Path output = Paths.get("src/StreamsFilesAndDirectoriesExercise/output.txt");

        try {
            List<String> firstFile = Files.readAllLines(input1);
            List<String> secondFile = Files.readAllLines(input2);
            Files.write(output, firstFile, StandardOpenOption.APPEND);
            Files.write(output, secondFile, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
