package fa.training.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.dao.DepartmentDAO;
import fa.training.entities.Department;
import fa.training.utils.DBConnection;
import fa.training.utils.SQLCommand;

public class DepartmentDAOImpl implements DepartmentDAO{

    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public List<Department> getAllDepartment() {
        List<Department> dList = new ArrayList<Department>();
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(SQLCommand.DEPARTMENT_QUERY_FIND_ALL);
            rs = pstm.executeQuery();

            while(rs.next()) {
                int deptId = rs.getInt("department_id");
                String deptName = rs.getString("department_name");
                String deptLocation = rs.getString("department_location");

                Department d = new Department(deptId, deptName, deptLocation);
                dList.add(d);
            }
            return dList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn, null, pstm, rs);
        }
        return null;
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        Department d = null;
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(SQLCommand.DEPARTMENT_QUERY_FIND_BY_ID);
            pstm.setInt(1, departmentId);

            rs = pstm.executeQuery();

            if(rs.next()) {
                int deptId = rs.getInt("department_id");
                String deptName = rs.getString("department_name");
                String deptLocation = rs.getString("department_location");

                d = new Department(deptId, deptName, deptLocation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn, null, pstm, rs);
        }

        return d;
    }

}
