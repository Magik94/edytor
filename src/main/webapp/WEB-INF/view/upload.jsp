<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Konwerter</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
    <h1 style="text-align: center;margin-bottom: 40px">Edytor obrazu</h1>
    <form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data"  class="form-group">
        <input type="file" name="file" class="form-control" style="margin-bottom: 40px"/>
        <select name="action"  class="form-control" style="margin-bottom: 40px">
            <c:forEach items="${actions}" var="action">
                <option value="${action}">${action}</option>
            </c:forEach>
        </select>
        <input  type="submit" value="Konwertuj" class="btn btn-default col-xs-12"/>
        <br>
        <a href="/imagesList" class="btn btn-default col-xs-12">Lista obrazów</a>
    </form>
</div>
</body>
</html>