package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {

    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //Method add(Pet pet) – adds an entity to the data if there is an empty cell for the pet.

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    //Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    //Method getPet(String name, String owner) –
    //returns the pet with the given name and owner or null if no such pet exists.

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    //Method getOldestPet() – returns the oldest Pet.
    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparing(Pet::getAge)).orElse(null);
    }

    // Getter getCount – returns the number of pets.
    public int getCount() {
        return this.data.size();
    }

    //getStatistics() – returns a String in the following format:
    //"The clinic has the following patients:
    //{name} {owner}
    //{name} {owner}
    //   (…)"

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : this.data) {
            builder.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
