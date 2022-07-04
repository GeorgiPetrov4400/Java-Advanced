package FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isFirstLetterUppercase = word -> Character.isUpperCase(word.charAt(0));

        List<String> upperCaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(isFirstLetterUppercase)
                .collect(Collectors.toList());

        System.out.println(upperCaseWords.size());

        System.out.println(String.join(System.lineSeparator(), upperCaseWords));

//        for (String word : upperCaseWords) {
//            System.out.println(word);
//        }
    }
}
