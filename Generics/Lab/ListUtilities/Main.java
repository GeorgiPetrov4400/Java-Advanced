package GenericsLab.ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 18, 21);

        System.out.println(ListUtils.getMin(numbers));
        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMax(new ArrayList<Integer>()));
    }
}
