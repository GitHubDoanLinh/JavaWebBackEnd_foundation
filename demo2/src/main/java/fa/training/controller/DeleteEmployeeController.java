package fa.training.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.EmployeeDAO;
import fa.training.dao.Impl.EmployeeDAOImpl;

@WebServlet(urlPatterns = "/views/deleteEmployee")
public class DeleteEmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    EmployeeDAO employeeDAO = null;

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAOImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deleteEmployee(req, resp);
        req.getRequestDispatcher("listEmployee").forward(req, resp);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int emp_id = Integer.valueOf(request.getParameter("emp_id"));
        employeeDAO.deleteEmployeeById(emp_id);
    }
}
