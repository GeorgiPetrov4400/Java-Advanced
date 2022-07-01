package DefiningClassesExercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];

            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < input.length; j = j + 2) {
                double tirePressure = Double.parseDouble(input[j]);
                int tireAge = Integer.parseInt(input[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }
            Car car = new Car(model, engine, cargo, tires);
            carsList.add(car);
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            for (Car car : carsList) {
                if (car.getCargo().getCargoType().equals(command)) {
                    int countTirePressure = 0;
                    for (Tire tire : car.getTires()) {
                        if (tire.getTirePressure() < 1) {
                            countTirePressure++;
                        }
                    }
                    if (countTirePressure != 0) {
                        System.out.println(car.getModel());
                    }
                }
            }
        } else if (command.equals("flamable")) {
            for (Car car : carsList) {
                if (car.getCargo().getCargoType().equals(command)) {
                    if (car.getEngine().getEnginePower() > 250) {
                        System.out.println(car.getModel());
                    }
                }
            }
        }
    }
}
//if(cargoType.equals("fragile")){
//        cars.stream()
//        .filter(car -> car.getCargo().getType().equals("fragile"))
//        .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getPressure() < 1))
//        .forEach(car -> System.out.println(car.getModel()));
//        }else {
//        cars.stream()
//        .filter(car -> car.getCargo().getType().equals("flamable"))
//        .filter(car -> car.getEngine().getPower() > 250)
//        .forEach(car -> System.out.println(car.getModel()));
//        }