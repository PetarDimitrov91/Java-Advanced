package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        HashMap<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String employeeData = console.nextLine();
            String[] parameters = employeeData.split("\\s+");

            String name = parameters[0];
            double salary = Double.parseDouble(parameters[1]);
            String position = parameters[2];
            String department = parameters[3];
            Employee employee = null;

            if (parameters.length == 6) {
                String email = parameters[4];
                int age = Integer.parseInt(parameters[5]);
                employee = new Employee(name, salary, position, department, email, age);

            } else if (parameters.length == 5) {
                String parameterForth = parameters[4];
                if (parameterForth.contains("@")) {
                    employee = new Employee(name, salary, position, department, parameterForth);
                } else {
                    int age = Integer.parseInt(parameterForth);
                    employee = new Employee(name, salary, position, department, age);
                }
                //  try {
                //      int age = Integer.parseInt(parameterForth);
                //      employee = new Employee(name, salary, position, department, age);
                //  } catch (NumberFormatException e) {
                //      String email = parameterForth;
                //      employee = new Employee(name, salary, position, department, email);
                //  }

            } else if (parameters.length == 4) {
                employee = new Employee(name, salary, position, department);
            }

            if (!departments.containsKey(department)) {
                departments.put(department, new Department(department));
            }
            departments.get(department).getEmployees().add(employee);
        }

        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry ->
                        entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);

    }
}
