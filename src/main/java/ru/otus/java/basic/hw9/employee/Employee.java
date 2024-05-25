package ru.otus.java.basic.hw9.employee;

public class Employee {
    /**
     * Employee's name
     */
    private final String name;
    /**
     * Employee's age
     */
    private int age;

    /**
     * Create an employee
     *
     * @param name employee's name
     * @param age  employee's age
     */
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Get employee's name
     *
     * @return employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get employee's age
     *
     * @return employee's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set employee's age
     *
     * @param age employee's age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
