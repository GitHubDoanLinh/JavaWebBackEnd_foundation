<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/25/2023
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
    Map<String, String> dic = new HashMap<>();
%>

<%
    dic.put("hello", "Xin chào");
    dic.put("banana", "quả chuối");
    dic.put("book", "Quyển sách");
    dic.put("apple", "Qủa táo");
    dic.put("how", "Thế nào");
    dic.put("computer", "Máy tính");


    String search = request.getParameter("search");

    String result = dic.get(search);
    if (result != null) {
        System.out.println("Word: " + search);
        System.out.println("Result: " + result);
    } else {
        System.out.println("Not found");
    }
%>
</body>
</html>
