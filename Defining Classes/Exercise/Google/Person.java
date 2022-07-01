package DefiningClassesExercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String personName;
    private Company company;
    private Car car;
    private List<Parent> parentList;
    private List<Child> childList;
    private List<Pokemon> pokemonList;

    public Person(String personName, Company company, Car car, List<Parent> parentList, List<Child> childList, List<Pokemon> pokemonList) {
        this.personName = personName;
        this.company = company;
        this.car = car;
        this.parentList = parentList;
        this.childList = childList;
        this.pokemonList = pokemonList;
    }

    public Person() {
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemonList;
    }

    public List<Parent> getParents() {
        return this.parentList;
    }

    public List<Child> getChildren() {
        return this.childList;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company).append("\n");
        }
        builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car).append("\n");
        }
        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemonList) {
            builder.append(pokemon).append("\n");
        }
        builder.append("Parents:").append("\n");
        for (Parent parent : parentList) {
            builder.append(parent).append("\n");
        }
        builder.append("Children:").append("\n");
        for (Child child : childList) {
            builder.append(child).append("\n");
        }
        return builder.toString();
    }
}
