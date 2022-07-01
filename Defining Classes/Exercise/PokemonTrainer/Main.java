package DefiningClassesExercise.PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainerList = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("Tournament")) {
            String[] data = line.split("\\s+");
            trainerList.putIfAbsent(data[0], new Trainer(data[0]));
            Trainer singleTrainer = trainerList.get(data[0]);
            singleTrainer.addPokemon(new Pokemon(data[1], data[2], Integer.parseInt(data[3])));

            line = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String finalElement = command;
            trainerList.values().forEach(s -> s.applyCommand(finalElement));

            command = scanner.nextLine();
        }
        trainerList.values().stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).forEach(System.out::println);
    }
}
