package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

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

    public void add(Rabbit rabbit) {
        if (this.data.size() < capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public void removeSpecies(String species) {
        List<Rabbit> rabbitsToRemove = this.data.stream()
                .filter(e -> e.getSpecies().equals(species))
                .collect(Collectors.toList());
        this.data.removeAll(rabbitsToRemove);
    }

    public Rabbit sellRabbit(String name) {
        Rabbit soldRabbit = null;
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                soldRabbit = rabbit;
                break;
            }
        }
        return soldRabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> soldRabbits = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                rabbit.setAvailable(false);
                soldRabbits.add(rabbit);
            }
        }
        return soldRabbits;
    }

    public int count() {
        return this.data.size();
    }


//TODO change sold rabbits

    public String report() {
        StringBuilder b = new StringBuilder();
        b.append(String.format("Rabbits available at %s:%n", getName()));
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()) {
                b.append(rabbit).append(System.lineSeparator());
            }
        }
        return b.toString();
    }

}
