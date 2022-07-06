package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ListFiles {
    public static void main(String[] args) {

        File root = new File("D:\\Java learning\\Advanced\\May2022\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Arrays.stream(root.listFiles())
                .filter(File::isFile)
                .forEach(f -> System.out.println(f.getName() + ": " + "[" + f.length() + "]"));
    }
}
