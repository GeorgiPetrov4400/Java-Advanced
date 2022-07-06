package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class NestedFolders {
    public static void main(String[] args) throws IOException {
        File root = new File("D:\\Java learning\\Advanced\\May2022\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(root);

        System.out.println(root.getName());
        int countDirectory = 1;
        while (!directories.isEmpty()) {
            File current = directories.poll();
            File[] nestedFiles = current.listFiles();
            for (File f : Objects.requireNonNull(nestedFiles)) {
                if (f.isDirectory()) {
                    directories.offer(f);
                    System.out.println(f.getName());
                    countDirectory++;
                }
            }
        }
        System.out.println(countDirectory + " folders");
    }
}