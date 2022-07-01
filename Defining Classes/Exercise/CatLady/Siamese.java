package DefiningClassesExercise.CatLady;

public class Siamese extends Cat {
    double earSize;

    public Siamese(String name, double earSize) {
        super(name, "Siamese");
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", this.earSize);
    }
}
