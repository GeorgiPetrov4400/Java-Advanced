package DefiningClassesExercise.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engineList = new ArrayList<>();

        int inputLinesEngine = Integer.parseInt(scanner.nextLine());

        Engine engine = null;
        for (int i = 0; i < inputLinesEngine; i++) {
            String[] inputEngineInfo = scanner.nextLine().split("\\s+");
            String engineModel = inputEngineInfo[0];
            int enginePower = Integer.parseInt(inputEngineInfo[1]);
            if (inputEngineInfo.length == 2) {
                engine = new Engine(engineModel, enginePower);
            } else if (inputEngineInfo.length == 3) {
                String data = inputEngineInfo[2];
                if (data.matches("\\d+")) {
                    int engineDisplacement = Integer.parseInt(data);
                    engine = new Engine(engineModel, enginePower, engineDisplacement);
                    //  engineList.add(engine);
                } else {
                    engine = new Engine(engineModel, enginePower, data);
                    //  engineList.add(engine);
                }
            } else if (inputEngineInfo.length == 4) {
                int engineDisplacement = Integer.parseInt(inputEngineInfo[2]);
                String engineEfficiency = inputEngineInfo[3];
                engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
                // engineList.add(engine);
            }
            engineList.add(engine);
        }
        List<Car> carList = new ArrayList<>();

        int inputLinesCar = Integer.parseInt(scanner.nextLine());

        Car car = null;
        for (int i = 0; i < inputLinesCar; i++) {
            String[] inputCarInfo = scanner.nextLine().split("\\s+");
            String carModel = inputCarInfo[0];
            String carEngine = inputCarInfo[1];
            if (inputCarInfo.length == 2) {
                car = new Car(carModel, carEngine);
              //  carList.add(car);
            } else if (inputCarInfo.length == 3) {
                String data = inputCarInfo[2];
                if (data.matches("\\d+")) {
                    int carWeight = Integer.parseInt(data);
                    car = new Car(carModel, carEngine, carWeight);
                   // carList.add(car);
                } else {
                    car = new Car(carModel, carEngine, data);
                   // carList.add(car);
                }
            } else if (inputCarInfo.length == 4) {
                int carWeight = Integer.parseInt(inputCarInfo[2]);
                String carColor = inputCarInfo[3];
                car = new Car(carModel, carEngine, carWeight, carColor);
               // carList.add(car);
            }
            carList.add(car);
        }
        System.out.println();
        for (Car carInfo : carList) {
            for (Engine engineInfo : engineList) {
                if (carInfo.getCarEngine().equals(engineInfo.getEngineModel())) {
                    System.out.printf("%s:%n", carInfo.getCarModel());
                    System.out.printf("%s:%n", carInfo.getCarEngine());
                    System.out.printf("Power: %d%n", engineInfo.getEnginePower());
                    if (engineInfo.getEngineDisplacement() == 0) {
                        System.out.printf("Displacement: n/a%n");
                    } else {
                        System.out.printf("Displacement: %d%n", engineInfo.getEngineDisplacement());
                    }
                    System.out.printf("Efficiency: %s%n", engineInfo.getEngineEfficiency());
                    if (carInfo.getCarWeight() == 0) {
                        System.out.printf("Weight: n/a%n");
                    } else {
                        System.out.printf("Weight: %d%n", carInfo.getCarWeight());
                    }
                    System.out.printf("Color: %s%n", carInfo.getCarColor());
                }
            }
        }
    }
}

