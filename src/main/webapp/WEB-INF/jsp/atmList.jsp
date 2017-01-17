<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>ATMs</title>
</head>
<body>
<a href="/logout">Logout</a>
<br>
<a href="/user/locator/atmform">New Search</a>

<h2>ATM</h2>
   <table>
       <tr>
           <th>Type</th>
           <th>Distance</th>
           <th>Housenumber</th>
           <th>Street</th>
           <th>City</th>
           <th>Postalcode</th>
           <th>Latitude</th>
           <th>Longitude</th>
       </tr>
       <c:forEach items="${atmList}" var="atm" begin="1" end="999999">

         <tr>
             <td>  ${atm.type}  </td>
             <td> ${atm.distance}  </td>
             <td>  ${atm.address.housenumber}  </td>
             <td>  ${atm.address.street}  </td>
             <td>  ${atm.address.city}  </td>
             <td>  ${atm.address.postalcode}  </td>
             <td>  ${atm.address.geoLocation.lat}  </td>
             <td>  ${atm.address.geoLocation.lng}  </td>
         </tr>
       </c:forEach>

</table>
</body>
</html>


