package fa.training.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fa.training.dao.EmployeeDAO;
import fa.training.entities.Department;
import fa.training.entities.Employee;
import fa.training.utils.DBConnection;
import fa.training.utils.SQLCommand;


public class EmployeeDAOImpl implements EmployeeDAO{

    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private DepartmentDAOImpl deptDAO = new DepartmentDAOImpl();

    @Override
    public boolean createEmployee(Employee e) {
        boolean check = false;

        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(SQLCommand.EMPLOYEE_QUERY_CREATE);
            pstm.setDate(1, Date.valueOf(e.getBirthDate()));
            pstm.setString(2, e.getEmployeeName());
            pstm.setBoolean(3, e.getGender());
            pstm.setDouble(4, e.getSalary());
            pstm.setInt(5, e.getDepartment().getDepartmentId());

            int result = pstm.executeUpdate();

            if(result == 1) {
                check = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn, null, pstm, rs);
        }

        return check;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee emp = null;

        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(SQLCommand.EMPLOYEE_QUERY_FIND_BY_ID);
            pstm.setInt(1, employeeId);

            rs = pstm.executeQuery();

            if(rs.next()) {
                String empName = rs.getString("employee_name");
                LocalDate birthDate = rs.getDate("birth_date").toLocalDate();
                Boolean gender = rs.getBoolean("gender");
                double salary = rs.getDouble("salary");
                int deptId = rs.getInt("department_id");
                Department d = deptDAO.getDepartmentById(deptId);

                emp = new Employee(employeeId, empName, false, birthDate, employeeId, d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn, null, pstm, rs);
        }

        return emp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> empList = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(SQLCommand.EMPLOYEE_QUERY_FIND_ALL);

            rs = pstm.executeQuery();
            while(rs.next()) {
                int empId = rs.getInt("employee_id");
                String empName = rs.getString("employee_name");
                LocalDate birthDate = rs.getDate("birth_date").toLocalDate();
                Boolean gender = rs.getBoolean("gender");
                double salary = rs.getDouble("salary");
                int deptId = rs.getInt("department_id");
                Department d = deptDAO.getDepartmentById(deptId);

                Employee emp = new Employee(empId, empName, gender, birthDate, salary, d);
                empList.add(emp);
            }

            return empList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn, null, pstm, rs);
        }

        return null;
    }

    @Override
    public boolean updateEmployee(Employee e) {
        boolean flag = false;

        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(SQLCommand.EMPLOYEE_QUERY_UPDATE);
            pstm.setString(1, e.getEmployeeName());
            pstm.setDate(2, Date.valueOf(e.getBirthDate()));
            pstm.setBoolean(3, e.getGender());
            pstm.setDouble(4, e.getSalary());
            pstm.setInt(5, e.getDepartment().getDepartmentId());
            pstm.setInt(6, e.getEmployeeId());

            int rowEffect = pstm.executeUpdate();
            if(rowEffect == 1) {
                flag = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn, null, pstm, rs);
        }

        return flag;
    }

    @Override
    public boolean deleteEmployeeById(int employeeId) {
        boolean check = false;

        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(SQLCommand.EMPLOYEE_QUERY_DELETE);
            pstm.setInt(1, employeeId);

            int result = pstm.executeUpdate();

            if(result == 1) {
                check = true;
            }
        } catch (Exception e) {

        } finally {
            DBConnection.closeConnection(conn, null, pstm, rs);
        }

        return check;
    }

}
