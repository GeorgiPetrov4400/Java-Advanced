package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class NestedFoldersAll {
    public static void main(String[] args) throws IOException {

        File root = new File("D:\\Java learning\\Advanced\\May2022\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        System.out.println(Files.walk(root.toPath())
                .map(Path::toFile)
                .map(File::getName)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
