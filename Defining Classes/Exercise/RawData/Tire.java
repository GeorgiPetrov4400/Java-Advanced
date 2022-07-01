package DefiningClassesExercise.RawData;

public class Tire {
    private double tirePressure;
    private int tyreAge;

    public Tire(double tirePressure, int tyreAge) {
        this.tirePressure = tirePressure;
        this.tyreAge = tyreAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(double tirePressure) {
        this.tirePressure = tirePressure;
    }

    public int getTyreAge() {
        return tyreAge;
    }

    public void setTyreAge(int tyreAge) {
        this.tyreAge = tyreAge;
    }
}
