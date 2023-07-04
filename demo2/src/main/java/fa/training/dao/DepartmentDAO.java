package fa.training.dao;

import java.util.List;

import fa.training.entities.Department;

public interface DepartmentDAO {
	List<Department> getAllDepartment();

	Department getDepartmentById(int departmentId);
}
