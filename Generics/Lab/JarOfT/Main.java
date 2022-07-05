package GenericsLab.JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();

//        jar.add("bahur");
//        jar.add("sudjuk");
//        jar.add("karvavica");
        jar.add(8);
        jar.add(88);
        jar.add(888);

        System.out.println(jar.remove());
        System.out.println(jar.remove());
    }
}
