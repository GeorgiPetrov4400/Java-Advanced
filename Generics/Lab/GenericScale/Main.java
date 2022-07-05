package GenericsLab.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("B", "B");
        System.out.println(scale.getHeavier());
    }
}
