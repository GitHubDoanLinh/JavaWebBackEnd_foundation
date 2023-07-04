package fa.training.dao;

import java.util.List;

import fa.training.entities.Employee;


public interface EmployeeDAO {
    boolean createEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    List<Employee> getAllEmployee();

    boolean updateEmployee(Employee employee);

    boolean deleteEmployeeById(int employeeId);
}
