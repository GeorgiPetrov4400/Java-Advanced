package GenericsExercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public T remove(int index) {
        return values.remove(index);
    }

    public boolean contains(T element) {
        if (this.values.contains(element)) {
            return true;
        }
        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(values, firstIndex, secondIndex);
    }

    public long countGreaterElement(T element) {
        return values.stream().filter(elementFromBox -> elementFromBox.compareTo(element) > 0).count();
    }

    public T max() {
        return values.stream().max(Comparator.naturalOrder()).get();
    }

    public T min() {
        return values.stream().min(Comparator.naturalOrder()).get();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T value : values) {
            builder.append(value).append("\n");
        }
        return builder.toString().trim();
    }
}
