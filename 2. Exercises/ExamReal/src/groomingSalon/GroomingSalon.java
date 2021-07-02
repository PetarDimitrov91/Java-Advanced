package groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        int index = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            this.data.remove(index);
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet currentPet : data) {
            if (currentPet.getName().equals(name) && currentPet.getOwner().equals(owner)) {
                return currentPet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder b = new StringBuilder(" The grooming salon has the following clients:");
        b.append(System.lineSeparator());
        for (Pet pet : data) {
            b.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }

        return b.toString();
    }

}
