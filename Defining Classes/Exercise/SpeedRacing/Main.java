package DefiningClassesExercise.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> carMap = new LinkedHashMap<>();

        //  List<Car> carList = new LinkedList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostPerKm = Double.parseDouble(input[2]);
            Car car = new Car(model, fuelAmount, fuelCostPerKm, 0);
            //   carList.add(car);
            carMap.put(model, car);
        }
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] data = line.split("\\s+");
            String carModel = data[1];
            int amountOfKm = Integer.parseInt(data[2]);
            double currentFuel = carMap.get(carModel).getFuelAmount();
            double costPerKm = carMap.get(carModel).getFuelCostPerKm();
            double fuelLeft = currentFuel - (amountOfKm * costPerKm);
            if (fuelLeft < 0) {
                System.out.println("Insufficient fuel for the drive");
                line = scanner.nextLine();
                continue;
            } else {
                carMap.get(carModel).setFuelAmount(fuelLeft);
                int currentDistanceTravelled = (int) carMap.get(carModel).getDistanceTraveled();
                int distanceTravelled = currentDistanceTravelled + amountOfKm;
                carMap.get(carModel).setDistanceTraveled(distanceTravelled);
            }

//            double currentFuel = carList.get(carList.indexOf(carModel)).getFuelAmount();
//            double costPerKm = carList.get(Integer.parseInt(carModel)).getFuelCostPerKm();
//            double fuelLeft = currentFuel - (amountOfKm * costPerKm);

            line = scanner.nextLine();
        }
        for (Map.Entry<String, Car> entry : carMap.entrySet()) {
            System.out.printf("%s %.2f %.0f%n", entry.getKey(), entry.getValue().getFuelAmount(), entry.getValue().getDistanceTraveled());
        }
    }
}
