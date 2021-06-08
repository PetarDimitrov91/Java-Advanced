package PokemonTrainer;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private int badges = 0;
    private List<Pokemon> pokemons;


    public Trainer() {
        this.pokemons = new ArrayList<>();
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public boolean containsElement(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getPokemonElement().contains(element)) {
                return true;
            }
        }
        return false;
    }

    public void filterPokemons() {
        this.pokemons = pokemons.stream()
                .filter(e -> e.getPokemonHealth() > 0)
                .collect(Collectors.toList());
    }
}
