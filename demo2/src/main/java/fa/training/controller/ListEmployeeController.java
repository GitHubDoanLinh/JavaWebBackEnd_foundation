package fa.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.EmployeeDAO;
import fa.training.dao.Impl.EmployeeDAOImpl;
import fa.training.entities.Employee;

@WebServlet(urlPatterns = "/views/listEmployee")
public class ListEmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO = null;

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeDAO.getAllEmployee();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("listEmployee.jsp").forward(req, resp);
    }

}
