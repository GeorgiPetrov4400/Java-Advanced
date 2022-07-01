package DefiningClassesExercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String trainerName;
    private int badgeNumber = 0;
    private List<Pokemon> pokemonList = new ArrayList<>();

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getName() {
        return trainerName;
    }

    public void setName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getBadges() {
        return badgeNumber;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public boolean hasElement(String element) {
        return this.pokemonList.stream().anyMatch(s -> s.getPokemonElement().equals(element));
    }

    public void applyCommand(String element) {
        if (hasElement(element)) {
            this.badgeNumber++;
        } else {
            this.pokemonList.forEach(Pokemon::looseHealth);
            this.pokemonList.removeIf(Pokemon::isDead);
        }
    }

    @Override
    public String toString() {
        return trainerName + " " + badgeNumber + " " + pokemonList.size();
    }
}

