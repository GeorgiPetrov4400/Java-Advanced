package ExamPreparation062022;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vowelsInput = scanner.nextLine().split("\\s+");
        String[] consonantsInput = scanner.nextLine().split("\\s+");

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        for (String letter : vowelsInput) {
            vowelsQueue.offer(letter);
        }

        ArrayDeque<String> consonantsStack = new ArrayDeque<>();
        for (String letter : consonantsInput) {
            consonantsStack.push(letter);
        }

        String[] words = {"pear", "flour", "pork", "olive"};
        String[] foundWords = {"****", "*****", "****", "*****"};

        while (!consonantsStack.isEmpty()) {
            String vowel = vowelsQueue.poll();
            String consonant = consonantsStack.pop();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int indexVowel = word.indexOf(vowel);
                int indexConsonant = word.indexOf(consonant);
                if (indexVowel >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexVowel) + vowel + foundWords[i].substring(indexVowel + 1);
                }
                if (indexConsonant >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexConsonant) + consonant + foundWords[i].substring(indexConsonant + 1);
                }
            }
            vowelsQueue.offer(vowel);
        }

        List<String> result = new ArrayList<>();
        for (String word : foundWords) {
            if (!word.contains("*")) {
                result.add(word);
            }
        }
        System.out.printf("Words found: %d%n", result.size());
        result.forEach(System.out::println);

//        List<String> output = Arrays.stream(foundWords).filter(w -> !w.contains("*")).collect(Collectors.toList());
//
//        System.out.printf("Words found: %d%n", output.size());
//        output.forEach(System.out::println);

//        String[] words = {"pear", "flour", "pork", "olive"};
//        String[] foundedWords = {"****", "*****", "****", "*****"};
//
//        int indexConsonant = -1;
//        int indexVowel = -1;
//        while (!consonantsStack.isEmpty()) {
//            String vowelsLetter = vowelsQueue.pop();
//            String consonantLetter = consonantsStack.poll();
//
//            for (String word : words) {
//                char[] wordArr = word.toCharArray();
//                for (char letter : wordArr) {
//                    if (letter == consonantLetter.charAt(0)) {
//                        indexConsonant = word.indexOf(consonantLetter);
//                    }
//                    if (letter == vowelsLetter.charAt(0)) {
//                        indexVowel = word.indexOf(vowelsLetter);
//                    }
//                }
//                int symbolCount = -1;
//                StringBuilder replaceWord = new StringBuilder();
//                for (String foundedWord : foundedWords) {
//                    char[] foundedWordArr = foundedWord.toCharArray();
//                    for (char symbol : foundedWordArr) {
//                        symbolCount++;
//                        if (symbolCount == indexVowel && indexVowel >= 0) {
//                            symbol = vowelsLetter.charAt(0);
//                            replaceWord.append(symbol);
//                        } else if (symbolCount != indexVowel && indexVowel >= 0) {
//                            symbol = '*';
//                            replaceWord.append(symbol);
//                        }
//                        if (symbolCount == indexConsonant && indexConsonant >= 0) {
//                            symbol = consonantLetter.charAt(0);
//                            replaceWord.append(symbol);
//                        } else if (symbolCount != indexConsonant && indexConsonant >= 0) {
//                            symbol = '*';
//                            replaceWord.append(symbol);
//                        }
//                    }
//                }
//            }
//
//
//            vowelsQueue.offer(vowelsLetter);
//
//        }
    }
}
