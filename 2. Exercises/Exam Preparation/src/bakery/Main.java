package bakery;

public class Main {
    public static void main(String[] args) {
        Bakery bakery = new Bakery("Barny", 10);
        Employee employee = new Employee("Stephan", 40, "(Bulgaria)");
        Employee employee1 = new Employee("Petar", 99, "(Bulgaria)");
        Employee employee2 = new Employee("Ivan", 26, "(Bulgaria)");
        Employee employee3 = new Employee("Georgi", 18, "(Bulgaria)");

        bakery.add(employee);
        bakery.add(employee1);
        bakery.add(employee2);
        bakery.add(employee3);
        bakery.remove("Petar");
        bakery.report();
        //   System.out.println(bakery.getCount());

    }
}
