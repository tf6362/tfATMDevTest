<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>ATM Locator</title>
</head>
<body>
<a href="/logout">Logout</a>
<br>
<a href="/user/locator/atmform">New Search</a>
<h2>ATM Locator</h2>
<form action="/user/locator/ATM" method="POST">

    <table  >
                <tr>
                   <th>City</th> <td><input type="city" name="city" value=""/></td>

                </tr>
                <tr>
                    <td colspan="2"><input type="submit" type="submit" value="Search"/></td>

                </tr>
                <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />


             </table>

     </form>
</body>
</html>
