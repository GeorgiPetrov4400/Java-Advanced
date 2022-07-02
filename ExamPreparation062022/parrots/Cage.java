package ExamPreparation062022.parrots_03;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldSpeciesList = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                soldSpeciesList.add(parrot);
            }
        }
        return soldSpeciesList;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Parrots available at %s:", this.name)).append("\n");
        for (Parrot parrot : data) {
            builder.append(parrot.toString()).append("\n");
        }
        return builder.toString();
    }
}
