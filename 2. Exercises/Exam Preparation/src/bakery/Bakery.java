package bakery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private String name;
    private int capacity;

    private List<bakery.Employee> employees;

    public Bakery(String bakeryName, int capacity) {
        this.name = bakeryName;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void add(Employee employee) {
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return this.employees.removeIf(employee -> employee.getName().contains(name));
    }

    public Employee getOldestEmployee() {
        Employee oldestEmployee = null;
        int age = 0;
        for (Employee employee : this.employees) {
            if (employee.getAge() > age) {
                age = employee.getAge();
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        Employee searchedEmployee = null;
        for (Employee employee : this.employees) {
            if (employee.getName().contains(name)) {
                searchedEmployee = employee;
            }
        }
        return searchedEmployee;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
            return this.employees
                    .stream()
                    .map(employee -> employee.toString() + "\n")
                    .collect(Collectors.joining
                            ("", String.format("Employees working at Bakery %s:", this.name) + "\n", "")).trim();
    }
}
