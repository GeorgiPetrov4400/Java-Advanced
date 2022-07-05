package GenericsExercise.GenericBoxInteger;

import java.util.ArrayList;
import java.util.List;

public class Box <T> {
    private List<T> value;

    public Box() {
        this.value = new ArrayList<>();
    }

    public void add(T element) {
        this.value.add(element);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : value) {
            builder.append(String.format("%s: %s%n", element.getClass().getName(), element.toString()));
        }
        return builder.toString();
    }
}
