package DefiningClassesExercise.CatLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        //  List<Cat> catList = new ArrayList<>();

        Map<String, Cat> catMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String catBreed = data[0];
            String catName = data[1];
            double catCharacteristic = Double.parseDouble(data[2]);
            switch (catBreed) {
                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(catName, catCharacteristic);
                    catMap.putIfAbsent(catName, streetExtraordinaire);
                    //   catList.add(streetExtraordinaire);
                    break;
                case "Siamese":
                    Siamese siamese = new Siamese(catName, catCharacteristic);
                    catMap.putIfAbsent(catName, siamese);
                    //   catList.add(siamese);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric(catName, catCharacteristic);
                    catMap.putIfAbsent(catName, cymric);
                    //   catList.add(cymric);
                    break;
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        System.out.println(catMap.get(input));
    }
}
