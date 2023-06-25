<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="converter.jsp" method="post">

    <lable>Rate: </lable><br/>
    <input type="text" name="rate" placeholder="Rate" value="22000"/><br/>

    <lable>Usd: </lable><br/>
    <input type="text" name="usd" placeholder="Usd" value="0"/><br/>

    <input type="submit" id="submit" value="Converter"/>
</form>
</body>
</html>