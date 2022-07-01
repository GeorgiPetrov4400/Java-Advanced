package DefiningClassesExercise.PokemonTrainer100;

public class Pokemon {
    private String pokemonName;
    private String pokemonElement;
    private String pokemonHealth;

    public Pokemon(String pokemonName, String pokemonElement, String pokemonHealth) {
        this.pokemonName = pokemonName;
        this.pokemonElement = pokemonElement;
        this.pokemonHealth = pokemonHealth;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonElement() {
        return pokemonElement;
    }

    public void setPokemonElement(String pokemonElement) {
        this.pokemonElement = pokemonElement;
    }

    public String getPokemonHealth() {
        return pokemonHealth;
    }

    public void setPokemonHealth(String pokemonHealth) {
        this.pokemonHealth = pokemonHealth;
    }
}
