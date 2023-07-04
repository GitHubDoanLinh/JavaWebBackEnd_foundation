package fa.training.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.DepartmentDAO;
import fa.training.dao.EmployeeDAO;
import fa.training.dao.Impl.EmployeeDAOImpl;
import fa.training.dao.Impl.DepartmentDAOImpl;
import fa.training.entities.Department;
import fa.training.entities.Employee;

@WebServlet(urlPatterns = "/views/updateEmployee")
public class UpdateEmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO = null;
    private DepartmentDAO departmentDAO = null;

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAOImpl();
        departmentDAO = new DepartmentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int emp_id = Integer.valueOf(req.getParameter("emp_id"));
        Employee employee = employeeDAO.getEmployeeById(emp_id);
        List<Department> departments = departmentDAO.getAllDepartment();
        req.setAttribute("departments", departments);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("updateEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int emp_id = Integer.valueOf(req.getParameter("emp_id"));
        System.out.println(emp_id);
        String employeeName = req.getParameter("employeeName");
        String gender = req.getParameter("gender");
        String birthDate = req.getParameter("birthDate");
        String salary = req.getParameter("salary");
        String departmentId = req.getParameter("departmentId");
        Employee employee = employeeDAO.getEmployeeById(emp_id);

        employee.setEmployeeName(employeeName);
        if ("male".equals(gender)) {
            employee.setGender(true);
        } else {
            employee.setGender(false);;
        }
        employee.setBirthDate(LocalDate.parse(birthDate, DateTimeFormatter.ISO_LOCAL_DATE));
        employee.setSalary(Double.parseDouble(salary));

        Department department = departmentDAO.getDepartmentById(Integer.parseInt(departmentId));

        employee.setDepartment(department);
        employeeDAO.updateEmployee(employee);
        resp.sendRedirect("listEmployee");
    }

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = null;
        employeeDAO = new EmployeeDAOImpl();
        Employee employee = employeeDAO.getEmployeeById(16);
        System.out.println(employee.getEmployeeName());

    }
}
