package SetsAndMapsAdvancedLab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continentCountryCityInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continentCountryCityInfo.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countryAndCityInfo = continentCountryCityInfo.get(continent);
            countryAndCityInfo.putIfAbsent(country, new ArrayList<>());
            List<String> cities = countryAndCityInfo.get(country);
            cities.add(city);
        }
        for (var entry : continentCountryCityInfo.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            for (var value : entry.getValue().entrySet()) {
                System.out.printf("  %s -> ", value.getKey());
                int count = 0;
                for (String city : value.getValue()) {
                    count++;
                    System.out.printf("%s", city);
                    if ((value.getValue().size() - 1) < count) {
                        break;
                    }
                    System.out.print(", ");
                }
                System.out.println();
            }
        }
    }
}
