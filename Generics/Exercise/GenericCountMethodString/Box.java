package GenericsExercise.GenericCountMethodString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> value;

    public Box() {
        this.value = new ArrayList<>();
    }

    public void add(T element) {
        this.value.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(value, firstIndex, secondIndex);
    }

    public int countGreaterElement(T element) {
     //   return value.stream().filter(elementFromBox -> elementFromBox.compareTo(element) > 0).count();
        int count = 0;
        for (T el : value) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : value) {
            builder.append(String.format("%s: %s%n", element.getClass().getName(), element.toString()));
        }
        return builder.toString();
    }
}
