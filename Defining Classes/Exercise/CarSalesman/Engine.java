package DefiningClassesExercise.CarSalesman;

public class Engine {
    private String engineModel;
    private int enginePower;
    //optional
    private int engineDisplacement;
    private String engineEfficiency;

    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = 0;
        this.engineEfficiency = "n/a";
    }

    public Engine(String engineModel, int enginePower, int engineDisplacement) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = "n/a";
    }

    public Engine(String engineModel, int enginePower, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineEfficiency = engineEfficiency;
        this.engineDisplacement = 0;
    }

    public Engine(String engineModel, int enginePower, int engineDisplacement, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public String getEngineEfficiency() {
        return engineEfficiency;
    }

    public void setEngineEfficiency(String engineEfficiency) {
        this.engineEfficiency = engineEfficiency;
    }
}
