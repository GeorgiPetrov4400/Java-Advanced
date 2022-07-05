package GenericsLab.GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] array = ArrayCreator.create(8, 13);
        for (Integer integer : array) {
            System.out.println(integer);
        }
        String[] array2 = ArrayCreator.create(3, "Joro");
        for (String name : array2) {
            System.out.println(name);
        }
    }
}
