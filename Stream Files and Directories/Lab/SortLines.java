package StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        List<String> sortedText = Files.readAllLines(Paths.get(path))
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Path output = Path.of("output-sorted-lines.txt");
        Files.createFile(output);
        Files.write(output, sortedText, StandardOpenOption.WRITE);
    }
}
