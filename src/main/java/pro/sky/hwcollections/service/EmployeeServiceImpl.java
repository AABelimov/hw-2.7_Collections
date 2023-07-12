package pro.sky.hwcollections.service;

import org.springframework.stereotype.Service;
import pro.sky.hwcollections.Employee;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> employeeBook = new HashMap<>(Map.of("IvanIvanov", new Employee("Ivan", "Ivanov", 2, 60000),
            "AlexandrAlexandrov", new Employee("Alexandr", "Alexandrov", 1, 70000)));

    @Override
    public String addEmployee(String firstName, String lastName, int department, double salary) {
        String fullName = firstName + lastName;
        if (!employeeBook.containsKey(fullName)) {
            Employee employee = new Employee(firstName, lastName, department, salary);
            employeeBook.put(fullName, employee);
            return "Employee added";
        } else return "Employee already added";
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        String fullName = firstName + lastName;
        if (employeeBook.remove(fullName) != null) {
            return "Employee removed";
        } else return "Employee not found";
    }

    @Override
    public String searchEmployee(String firstName, String lastName) {
        String fullName = firstName + lastName;
        if (employeeBook.containsKey(fullName)) {
            return employeeBook.get(fullName).toString();
        } else return "Employee not found";
    }

    @Override
    public String getEmployeeBook() {
        StringBuilder builder = new StringBuilder(65 * employeeBook.size());

        for (Employee employee : employeeBook.values()) {
            builder.append(employee);
            builder.append('\n');
        }
        return builder.toString();
    }
}
