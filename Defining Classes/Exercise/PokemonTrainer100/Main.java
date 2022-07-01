package DefiningClassesExercise.PokemonTrainer100;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, List<Pokemon>> trainerAndPokemonMap = new LinkedHashMap<>();

        while (!line.equals("Tournament")) {
            String[] data = line.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            String pokemonHealth = data[3];
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (trainerAndPokemonMap.containsKey(trainerName)) {
                trainerAndPokemonMap.get(trainerName).add(pokemon);
            } else {
                trainerAndPokemonMap.put(trainerName, new ArrayList<>());
                trainerAndPokemonMap.get(trainerName).add(pokemon);
            }

            line = scanner.nextLine();
        }
        String command = scanner.nextLine();

        Map<String, Integer> trainerAndBadgeMap = new LinkedHashMap<>();

        while (!command.equals("End")) {
            for (Map.Entry<String, List<Pokemon>> entry : trainerAndPokemonMap.entrySet()) {
                int countElement = 0;
                for (Pokemon pokemon : entry.getValue()) {
                    if (pokemon.getPokemonElement().contains(command)) {
                        countElement++;
                    }
                }
                if (countElement == 0) {
                    trainerAndBadgeMap.putIfAbsent(entry.getKey(), 0);
                    if (entry.getValue().size() > 0) {
                        for (int i = entry.getValue().size() - 1; i >= 0; i--) {
                            int currentHealth = Integer.parseInt(entry.getValue().get(i).getPokemonHealth());
                            int health = currentHealth - 10;
                            entry.getValue().get(i).setPokemonHealth(String.valueOf(health));
                            if (health <= 0) {
                                trainerAndPokemonMap.get(entry.getKey()).remove(entry.getValue().get(i));
                            }
                            if (trainerAndPokemonMap.get(entry.getKey()).size() == 0) {
                                break;
                            }
                        }
//                        for (Pokemon pokemon : entry.getValue()) {
//                            int currentHealth = Integer.parseInt(pokemon.getPokemonHealth());
//                            int health = currentHealth - 10;
//                            pokemon.setPokemonHealth(String.valueOf(health));
//                            if (health <= 0) {
//                                trainerAndPokemonMap.get(entry.getKey()).remove(pokemon);
//                            }
//                            if (trainerAndPokemonMap.get(entry.getKey()).size() == 0) {
//                                break;
//                            }
//                        }
                    }
                } else {
                    trainerAndBadgeMap.putIfAbsent(entry.getKey(), 0);
                    int currentBadges = trainerAndBadgeMap.get(entry.getKey());
                    trainerAndBadgeMap.put(entry.getKey(), currentBadges + 1);
                }
            }

            command = scanner.nextLine();
        }
        if (trainerAndBadgeMap.isEmpty()) {
            for (Map.Entry<String, List<Pokemon>> entry : trainerAndPokemonMap.entrySet()) {
                System.out.printf("%s 0 %s%n", entry.getKey(), trainerAndPokemonMap.get(entry.getKey()).size());
            }
        } else {
            trainerAndBadgeMap = trainerAndBadgeMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            for (Map.Entry<String, Integer> entry : trainerAndBadgeMap.entrySet()) {
                System.out.printf("%s %d %s%n", entry.getKey(), entry.getValue(), trainerAndPokemonMap.get(entry.getKey()).size());
            }
        }
    }
}

