package DefiningClassesExercise.PokemonTrainer100;

public class Trainer {
    private String trainerName;
    private int numberOfBadges;
  //  private List<Pokemon> pokemon;

    public Trainer(String trainerName, int numberOfBadges) {
        this.trainerName = trainerName;
        this.numberOfBadges = numberOfBadges;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }
}
