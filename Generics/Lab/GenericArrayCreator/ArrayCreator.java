package GenericsLab.GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {
    public static <T> T[] create(int length, T value) {
        T[] array = (T[]) Array.newInstance(value.getClass(), length);

        Arrays.fill(array, value);

        return array;
    }

    public static <T> T[] create(Class<T> clazz, int length, T value) {
        T[] array = (T[]) Array.newInstance(clazz, length);

        Arrays.fill(array, value);

        return array;
    }
}
