package bakery;

public class Main {
    public static void main(String[] args) {
        Bakery bakery = new Bakery("Barny",10);
        Employee employee = new Employee("Stephan",40,"(Bulgaria)");
        Employee employee1 = new Employee("Petar",99,"(Bulgaria)");

        bakery.add(employee);
        bakery.add(employee1);
        bakery.remove("Petar");
        System.out.println(bakery.GetOldestEmployee());
    }
}
