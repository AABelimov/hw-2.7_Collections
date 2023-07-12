package pro.sky.hwcollections;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int department;
    private final double salary;

    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nDepartment: %d\nSalary: %,.2f\n", lastName + ' ' + firstName, department, salary);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Employee otherEmployee = (Employee) other;
        return Objects.equals(firstName, otherEmployee.getFirstName()) && Objects.equals(lastName, otherEmployee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}