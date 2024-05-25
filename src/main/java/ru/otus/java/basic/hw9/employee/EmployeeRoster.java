package ru.otus.java.basic.hw9.employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRoster {
    /**
     * Creates a list of names of employees
     *
     * @param list list of employees
     * @return list of names
     */
    public static List<String> getEmployeeNames(List<Employee> list) {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        return list.stream().map(employee -> employee == null ? null : employee.getName()).collect(Collectors.toList());
    }

    /**
     * Creates a list of employees as old as a certain age
     *
     * @param list list of employees
     * @param age  minimum age of the resulting employees list
     * @return list of employees as old as specified age
     */
    public static List<Employee> getEmployeesAsOldAs(List<Employee> list, int age) {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        return list.stream().filter(employee -> employee != null && employee.getAge() >= age).collect(Collectors.toList());
    }

    /**
     * Checks if employees' average age is greater or equal to specified age
     *
     * @param list list of employees
     * @param age  age to compare the employees' average age to
     * @return true if the employees' average age is greater or equal to specified age, false otherwise
     */
    public static boolean isEmployeesAverageAgeGreaterOrEquals(List<Employee> list, int age) {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        return (list.stream().reduce(0.0, (sum, employee) -> employee == null ? sum : sum + employee.getAge(), Double::sum)
                / list.stream().reduce(0, (count, employee) -> employee == null ? count : count + 1, Integer::sum)) >= age;
    }

    /**
     * Find the youngest employee in a list
     *
     * @param list list of employees
     * @return Option of first youngest employee found in the list, or empty if not found
     */
    public static Optional<Employee> getYoungestEmployee(List<Employee> list) {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        Employee result = null;
        for (Employee employee : list) {
            if (employee != null) {
                if (result == null || employee.getAge() < result.getAge()) {
                    result = employee;
                }
            }
        }
        return result == null ? Optional.empty() : Optional.of(result);
    }

    public static void main(String[] args) {
        List<Employee> testList = Arrays.asList(
                new Employee("Ivanov", 65),
                new Employee("Petrov", 35),
                new Employee("Sidoroff", 25)
        );
        System.out.println("getEmployeeNames(testList) = " + getEmployeeNames(testList));
        System.out.println("isEmployeesAverageAgeGreaterOrEquals(testList, 35) = " + isEmployeesAverageAgeGreaterOrEquals(testList, 35));
        System.out.println("getYoungestEmployee(testList).stream().map(Employee::getName).findAny().orElse(\"Not Found\") = "
                + getYoungestEmployee(testList).stream().map(Employee::getName).findAny().orElse("Not Found"));
    }
}
