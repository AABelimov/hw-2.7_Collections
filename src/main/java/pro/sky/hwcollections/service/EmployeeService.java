package pro.sky.hwcollections.service;

public interface EmployeeService {
    String addEmployee(String firstName, String lastName, int department, double salary);

    String removeEmployee(String firstName, String lastName);

    String searchEmployee(String firstName, String lastName);

    String getEmployeeBook();
}
