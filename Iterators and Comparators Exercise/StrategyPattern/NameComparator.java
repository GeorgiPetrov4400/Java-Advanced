package IteratorsAndComparatorsExercise.StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() == second.getName().length()) {
            char firstPersonFirstLetter = first.getName().toLowerCase().charAt(0);
            char secondPersonFirstLetter = second.getName().toLowerCase().charAt(0);
            return Character.compare(firstPersonFirstLetter, secondPersonFirstLetter);
        }
        return Integer.compare(first.getName().length(), (second.getName().length()));
    }
}
