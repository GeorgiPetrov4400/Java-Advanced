package ExamPreparation062022.dealership_03;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        // data.stream().sorted((car1, car2) -> car1.getYear() > car2.getYear())
        Car car = null;
        int latestYear = Integer.MIN_VALUE;
        for (Car carInfo : data) {
            if (carInfo.getYear() > latestYear) {
                latestYear = carInfo.getYear();
                car = carInfo;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are in a car dealership %s:%n", this.name));
        for (Car car : data) {
            builder.append(car.toString()).append("\n");
        }
        return builder.toString();
    }

}
