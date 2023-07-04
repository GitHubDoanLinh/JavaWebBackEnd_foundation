</table><%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <link rel="stylesheet" href="style.css" />
  <title>Employee List</title>
  <link rel="stylesheet" href="../resources/css/style.css" />

</head>
<body>
<div class="contain">
  <h1>Employee Management Web Application</h1>
  <div class="content">
    <div class="content-menu">
      <h4>Menu</h4>
      <a href="createEmployee">Create New Employee</a> <a href="listEmployee">View Employee List</a>
    </div>
    <div class="content-form">
      <h3>Employee List</h3>
      <table border ="2" class="table table-hover" style="width: 100%">
        <tr class="table-header">
          <th>Employee ID</th>
          <th>Employee Name</th>
          <th>Gender</th>
          <th>Birth Date</th>
          <th>Salary</th>
          <th>Department Name</th>
          <th colspan="2"></th>

        </tr>
        <c:forEach items="${employees}" var="emp">
          <tr>
            <td>${emp.employeeId}</td>
            <td>${emp.employeeName}</td>
            <td>
              <c:choose>
                <c:when test="${emp.gender == false}">
                  Female
                </c:when>
                <c:otherwise>
                  Male
                </c:otherwise>
              </c:choose>
            </td>
            <td>${emp.birthDate}</td>
            <td>${emp.salary}</td>
            <td>${emp.department.departmentName}</td>
            <td><a href="updateEmployee?emp_id=${emp.employeeId}">Update</a></td>
            <td><a href="#" onclick="deleteEmployee(${emp.employeeId})">Delete</a></td>

          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
  <div class="footer">
    <p>Copyright - Doan Linh Codegym</p>
  </div>
</div>
<script type="text/javascript"></script>
</body>

<script>
  function deleteEmployee(id){
    var option = confirm('Do you want to delete this employee?');
    if(option === true){
      window.location.href = 'deleteEmployee?emp_id='+ id;
    }
  }
</script>
</html>