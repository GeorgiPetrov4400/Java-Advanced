package DefiningClassesExercise.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> peopleMap = new HashMap<>();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String personName = data[0];
            if (!peopleMap.containsKey(personName)) {
                peopleMap.put(personName, new Person());
            }
            String classType = data[1];
            switch (classType) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    peopleMap.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleMap.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    peopleMap.get(personName).getParents().add(parent);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Child child = new Child(childName, childBirthday);
                    peopleMap.get(personName).getChildren().add(child);
                    break;
                case "car":
                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carModel, carSpeed);
                    peopleMap.get(personName).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }
        String printPersonInfo = scanner.nextLine();
        System.out.println(printPersonInfo);

        Person personInfo = peopleMap.get(printPersonInfo);
        System.out.println(personInfo);
    }
}
