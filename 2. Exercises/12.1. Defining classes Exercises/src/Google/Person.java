package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Company company;
    private Car car;

    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();

    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Company:").append("\n");

        if (company != null) {
            builder.append(company.toString()).append("\n");
        }
        builder.append("Car:").append("\n");

        if (car != null) {
            builder.append(car.toString()).append("\n");
        }
        builder.append("Pokemon:").append("\n");

        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon.toString()).append("\n");
        }
        builder.append("Parents:").append("\n");
        for (Parent parent : parents) {
            builder.append(parent).append("\n");
        }
        builder.append("Children:").append("\n");
        for (Child child : children) {
            builder.append(child).append("\n");
        }
        return builder.toString();

    }
}
