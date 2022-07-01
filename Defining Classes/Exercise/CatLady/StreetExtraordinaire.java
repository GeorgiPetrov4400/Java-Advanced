package DefiningClassesExercise.CatLady;

public class StreetExtraordinaire extends Cat {
    double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name, "StreetExtraordinaire");
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", this.decibelsOfMeows);
    }
}
