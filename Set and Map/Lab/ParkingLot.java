package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] data = input.split(", ");
            String command = data[0];
            String licensePlate = data[1];
            switch (command) {
                case "IN":
                    parking.add(licensePlate);
                    break;
                case "OUT":
                    parking.remove(licensePlate);
                    break;
            }

            input = scanner.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String element : parking) {
                System.out.println(element);
            }
        }
    }
}
