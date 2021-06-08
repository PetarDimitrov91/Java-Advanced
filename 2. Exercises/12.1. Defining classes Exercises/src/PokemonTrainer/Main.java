package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String command = console.readLine();

        LinkedHashMap<String, Trainer> trainerData = new LinkedHashMap<>();

        while (!command.equals("Tournament")) {
            String[] catchingData = command.split("\\s+");
            String trainerName = catchingData[0];
            String pokemonName = catchingData[1];
            String pokemonElement = catchingData[2];
            int pokemonHealth = Integer.parseInt(catchingData[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer();

            if (!trainerData.containsKey(trainerName)) {
                trainerData.put(trainerName, trainer);
            }
            trainerData.get(trainerName).getPokemons().add(pokemon);
            command = console.readLine();
        }

        command = console.readLine();

        while (!command.equals("End")) {

            for (var entry : trainerData.entrySet()) {
                if (entry.getValue().containsElement(command)) {
                    entry.getValue().setBadges(entry.getValue().getBadges() + 1);
                } else {
                    for (Pokemon pokemon : entry.getValue().getPokemons()) {
                        pokemon.setPokemonHealth(pokemon.getPokemonHealth() - 10);
                    }
                }
                trainerData.forEach((key, value) -> value.filterPokemons());
            }
            command = console.readLine();
        }

       // trainerData.forEach((key, value) -> value.filterPokemons());

        trainerData.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Trainer::getBadges).reversed()))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue().getBadges() + " " + e.getValue().getPokemons().size()));

    }
}
