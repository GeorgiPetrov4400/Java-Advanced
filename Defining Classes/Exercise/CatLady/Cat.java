package DefiningClassesExercise.CatLady;

public class Cat {
    String name;
    String breed;

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return this.breed + " " + this.name;
    }
}
