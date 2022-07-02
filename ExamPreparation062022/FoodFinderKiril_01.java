package ExamPreparation062022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FoodFinderKiril_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = {"pear", "flour", "pork", "olive"};
        String[] foundWords = {"****", "*****", "****", "*****"};

        ArrayDeque<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(e -> vowels.offer(e.charAt(0)));

        ArrayDeque<Character> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(e -> consonants.push(e.charAt(0)));

        while (consonants.size() > 0) {
            char consonant = consonants.pop();
            char vowel = vowels.poll();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int indexOfVowel = word.indexOf(vowel);
                int indexOfConsonant = word.indexOf(consonant);

                if (indexOfVowel >= 0) {
                    StringBuilder sb = new StringBuilder();
                    char[] charsInCurrWord = foundWords[i].toCharArray();
                    charsInCurrWord[indexOfVowel] = vowel;

                    for (char curChar : charsInCurrWord) {
                        sb.append(curChar);
                    }
                    String omg = sb.toString();
                    foundWords[i] = omg;
                }

                if (indexOfConsonant >= 0) {
                    StringBuilder sb = new StringBuilder();
                    char[] charsInCurrWord = foundWords[i].toCharArray();
                    charsInCurrWord[indexOfConsonant] = consonant;

                    for (char curChar : charsInCurrWord) {
                        sb.append(curChar);
                    }
                    String omg = sb.toString();
                    foundWords[i] = omg;
                }
            }
            vowels.offer(vowel);
        }

        List<String> output = Arrays.stream(foundWords).filter(word -> !word.contains("*")).collect(Collectors.toList());

        System.out.printf("Words found: %d%n", output.size());
        output.forEach(System.out::println);
    }
}
