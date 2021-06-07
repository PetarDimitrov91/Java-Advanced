package CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Department {
    String name;
    private List<Employee> employees;


    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

 //  public void addEmployee(Employee employee) {
 //      this.employees.add(employee);
 //  }

 //  public void showEmployees() {
 //      employees
 //              .stream()
 //              .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
 //              .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
 //  }

    public double getAverageSalary() {
      //  double salarySum = employees.stream().mapToDouble(Employee::getSalary).sum();
      //  return salarySum / employees.size();

        return this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }

    public String getName(){
        return this.name;
    }


}
