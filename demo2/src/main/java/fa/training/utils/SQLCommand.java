package fa.training.utils;

public class SQLCommand {
	//Department query
	public static final String DEPARTMENT_QUERY_FIND_ALL = "SELECT * FROM Department";
	public static final String DEPARTMENT_QUERY_FIND_BY_ID = "SELECT * FROM Department WHERE department_id = ?";

	//Employee queryDepartmentDAOImpl
	public static final String EMPLOYEE_QUERY_CREATE = "INSERT INTO Employee(birth_date,employee_name,gender,salary,department_id) VALUES (?,?,?,?,?)";
	public static final String EMPLOYEE_QUERY_UPDATE = "UPDATE Employee SET employee_name = ?, birth_date = ?,"
															+ "gender = ?, salary = ?, department_id = ?"
																+" Where employee_id = ?";
	public static final String EMPLOYEE_QUERY_FIND_ALL = "SELECT * FROM Employee";
	public static final String EMPLOYEE_QUERY_FIND_BY_ID = "SELECT * FROM Employee WHERE employee_id = ?";
	public static final String EMPLOYEE_QUERY_DELETE = "DELETE FROM Employee WHERE employee_id = ?";
}
