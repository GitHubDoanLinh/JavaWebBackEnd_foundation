<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <link rel="stylesheet" href="../resources/css/style.css" />
  <title>Insert title here</title>
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
      <h3>Enter Employee Details</h3>
      <form action="createEmployee" method="post" id="createForm">
        <div class="form-group">
          <label class="title" for="">Employee Name:</label>
          <input type="text" name="employeeName" />
        </div>
        <div class="form-group">
          <label class="title" for="">Gender:</label>
          <input type="radio" id="gender" name="gender" value="male" checked="true" /> Male
          <input type="radio" id="gender" name="gender" value="female" />Female
        </div>

        <div class="form-group">
          <label class="title" for="birthDate">BirthDate:</label>
          <input type="date" name="birthDate"/>
        </div>
        <div class="form-group">
          <label class="title" for="salary">Salary:</label>
          <input type="number" name="salary"/>
        </div>
        <div class="form-group">
          <label class="title" for="departmentName">Department Name:</label>
          <select class="form-control" name="departmentId">
            <c:forEach items="${departments}" var="dept">
              <option value="${dept.departmentId}">${dept.departmentName }</option>
            </c:forEach>
          </select>
        </div>
        <button type="submit">Save</button>
      </form>
    </div>
  </div>
  <div class="footer">
    <p>Copyright - Doan Linh Codegym</p>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="../resources/js/main.js"></script>
</body>
</html>