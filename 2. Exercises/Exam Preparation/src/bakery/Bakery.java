package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;


    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    List<Employee> employeesData = new ArrayList<>(capacity);

    public void add(Employee employee) {
        if (employeesData.size() < capacity) {
            this.employeesData.add(employee);
        }
    }

    public void remove(String name) {
        employeesData.removeIf(employee -> employee.getName().equals(name));

    }

    public Employee getEmployee(String name) {
        for (Employee employee : employeesData) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public Employee GetOldestEmployee() {
        int age = 0;
        Employee oldestEmployee = null;
        for (Employee employee : employeesData) {
            int currentEmployeeAge = employee.getAge();
            if (age < currentEmployeeAge) {
                age = currentEmployeeAge;
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }
    public void report() {
        System.out.printf("Employees working at Bakery %s:");
    }
}
