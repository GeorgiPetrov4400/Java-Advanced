package DefiningClassesExercise.CarSalesman;

public class Car {
    private String carModel;
    private String carEngine;
    //optional
    private int carWeight;
    private String carColor;

    public Car(String carModel, String carEngine) {
        this.carModel = carModel;
        this.carEngine = carEngine;
        this.carWeight = 0;
        this.carColor = "n/a";
    }

    public Car(String carModel, String carEngine, int carWeight, String carColor) {
        this.carModel = carModel;
        this.carEngine = carEngine;
        this.carWeight = carWeight;
        this.carColor = carColor;
    }

    public Car(String carModel, String carEngine, int carWeight) {
        this.carModel = carModel;
        this.carEngine = carEngine;
        this.carWeight = carWeight;
        this.carColor = "n/a";
    }

    public Car(String carModel, String carEngine, String carColor) {
        this.carModel = carModel;
        this.carEngine = carEngine;
        this.carColor = carColor;
        this.carWeight = 0;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public int getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(int carWeight) {
        this.carWeight = carWeight;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}

