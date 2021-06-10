package bakery;

public class Employee {
    private String name;
    private int age;
    private String country;

    public Employee(String employeeName, int employeeAge, String employeeCountry) {
        this.name = employeeName;
        this.age = employeeAge;
        this.country = employeeCountry;
    }

    public String getCountry() {
        return this.country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d (%s)", this.name, this.age, this.country);
    }

}
