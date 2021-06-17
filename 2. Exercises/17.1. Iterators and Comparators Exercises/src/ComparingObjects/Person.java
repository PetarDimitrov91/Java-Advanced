package ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public int compareTo(Person p2) {
        int result = this.name.compareTo(p2.name);
        if (result == 0) {
            result = Integer.compare(this.age, p2.age);
        }
        if (result == 0) {
            result = this.city.compareTo(p2.city);
        }
        return result;
    }
}
