<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html  >
<head>
    <title>Hub Practice</title>
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <style>
       table, th , td {
          border: 1px solid grey;
          border-collapse: collapse;
          padding: 5px;
       }

       table tr:nth-child(odd) {
          background-color: #f2f2f2;
       }

       table tr:nth-child(even) {
          background-color: #ffffff;
       }
    </style>
    <script src="//code.angularjs.org/snapshot/angular.min.js"></script>
    <script>
    (function(angular) {
      'use strict';
    angular.module('app', [])
   .controller("hubLoginController",hubPracticeController);

   function hubPracticeController($scope,$http) {
       /*
       $scope.selectedPractice ='';

    var url = "/listHubPractice.json";
       if($scope.selectedPractice==''){
        $http({
          method: 'GET',
          url: url
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available

                    $scope.hubPractices=response.data;
          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
       }else{



       }
    */
    }

       hubLoginController.$inject = ['$scope','$http'];
    })(window.angular);
   </script>
</head>
<body onload="document.f.username.focus();">

<h3><% if(request.getParameter("deniedMessage") != null)  out.print(request.getParameter("deniedMessage"));%> </h3>

<h3> Login with Username and Password:</h3>
<div ng-app="app" ng-controller="hubLoginController">
    <form action="/login" method="POST">

    <table  >
                <tr>
                   <th>User Name</th> <td><input type="text" name="username" value=""/></td>
                   <th>Password</th><td><input type="password" name="password" value=""/></td>

                </tr>
                <tr>
                    <td colspan="2"><input type="submit" type="submit" value="Login"/></td>

                </tr>
                <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />


             </table>

     </form>

</div>




</body>
</html>