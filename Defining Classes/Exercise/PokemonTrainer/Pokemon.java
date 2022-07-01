package DefiningClassesExercise.PokemonTrainer;

public class Pokemon {
    private String pokemonName;
    private String pokemonElement;
    private int pokemonHealth;

    public Pokemon(String pokemonName, String pokemonElement, int pokemonHealth) {
        this.pokemonName = pokemonName;
        this.pokemonElement = pokemonElement;
        this.pokemonHealth = pokemonHealth;
    }

    public void looseHealth() {
        this.pokemonHealth -= 10;
    }

    public boolean isDead() {
        return this.pokemonHealth <= 0;
    }

    public String getName() {
        return pokemonName;
    }

    public void setName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonElement() {
        return pokemonElement;
    }
}
