package StreamsFilesAndDirectoriesExercise;

import java.io.File;
import java.util.ArrayDeque;

public class GetFolderSize {
    public static void main(String[] args) {
        File folder = new File("src/StreamsFilesAndDirectoriesExercise/Exercises Resources");
        ArrayDeque<File> files = new ArrayDeque<>();
        files.offer(folder);
        int totalSize = 0;
        while (!files.isEmpty()) {
            File currentFile = files.poll();
            File[] nestedFiles = currentFile.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    files.offer(nestedFile);
                } else {
                    totalSize += nestedFile.length();
                }
            }
        }
        System.out.printf("Folder size: %d%n", totalSize);
    }
}
