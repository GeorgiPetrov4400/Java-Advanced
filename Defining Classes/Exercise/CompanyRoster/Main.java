package DefiningClassesExercise.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> departmentsMap = new HashMap<>();

        Employee employee = null;
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (input.length == 5) {
                String data = input[4];
                if (data.matches("\\d+")) {
                    int age = Integer.parseInt(data);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    employee = new Employee(name, salary, position, department, data);
                }
            } else if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            if (!departmentsMap.containsKey(department)) {
                departmentsMap.put(department, new ArrayList<>());
                departmentsMap.get(department).add(employee);
            } else {
                departmentsMap.get(department).add(employee);
            }
        }
        String maxAverageSalary = departmentsMap.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalary);
        List<Employee> employeeList = departmentsMap.get(maxAverageSalary);
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary));
        Collections.reverse(employeeList);
        for (Employee person : employeeList) {
            System.out.println(person.toString());
        }
    }

    public static double getAverageSalary(List<Employee> employees) {
        double sum = 0.0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
