package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();


    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        return this.products.stream().mapToInt(Vegetable::getCalories).sum();
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(String.format("* Salad %s is %d calories and have %d products:%n",
                getName(), getTotalCalories(), getProductCount()));
        for (Vegetable product : this.products) {
            b.append(product).append(System.lineSeparator());
        }
        //Check by exam when problem comes
        return b.toString().trim();
    }
}
