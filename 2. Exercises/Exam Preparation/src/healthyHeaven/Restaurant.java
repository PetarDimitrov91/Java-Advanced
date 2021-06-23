package healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {

    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Salad getHealthiestSalad() {
        return this.data.stream()
                .min(Comparator.comparingInt(Salad::getTotalCalories))
                .orElse(null);


    }

    public String generateMenu() {
        StringBuilder b = new StringBuilder();
        b.append(String.format("%s have %d salads:%n", this.name, this.data.size()));
        for (Salad salad : data) {
            b.append(salad).append(System.lineSeparator());
        }
        return b.toString().trim();
    }
}
