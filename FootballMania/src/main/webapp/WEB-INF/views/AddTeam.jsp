<%@include file="AdminHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script>
  var teamDisplay = ${TeamList};
  var ctr;
  angular.module('myTeam', []).controller('teamController', function($scope)
   {
                $scope.teams=teamDisplay;
           
    });
  </script>




<!-- update form -->
<c:choose>
<c:when test="${updateClicked==true}">
<div  class="container col-sm-6">
<div class="jumbotron">
<p>Update your Team here!</p>
<form:form method="POST" action="updateTeamtoDB" commandName="command" enctype="multipart/form-data"> 
  <div class="form-group row">
    <form:label for="TeamID" path="teamId">Enter Team ID</form:label>
    <form:input type="text" class="form-control" path="teamId" placeholder="Enter the ID provided to you" required="required" readonly="true"/>
  </div>
  <div class="form-group row">
    <form:label for="TeamName" path="teamName">Enter Team Name</form:label>
    <form:input type="text" class="form-control" path="teamName" placeholder="Enter the final Team Name" required="required"/>
  </div>
  <div class="form-group row">
    <form:label  path="teamImage">Upload Image</form:label>
    <form:input type="file" class="form-control" path="teamImage"/>
  </div>
  
  <div class="form-group row" >
       <button type="submit">Update Team</button>
      </div>
</form:form>
</div>
</div>
 </c:when>
  <c:otherwise>
  <!-- add form -->
<div  class="container col-sm-6">
<div class="jumbotron">
<p>Add your Team here!</p>
<form:form method="POST" action="addTeam" commandName="command" enctype="multipart/form-data"> 
  <div class="form-group row">
    <form:label  path="teamId">Enter Team ID</form:label>
    <form:input type="text" class="form-control" path="teamId" placeholder="Enter the ID provided to you" required="required"/>
  </div>
  <div class="form-group row">
    <form:label  path="teamName">Enter Team Name</form:label>
    <form:input type="text" class="form-control" path="teamName" placeholder="Enter the final Team Name" required="required"/>
  </div>
  <div class="form-group row">
    <form:label  path="teamImage">Upload Image</form:label>
    <form:input type="file" class="form-control" path="teamImage"/>
  </div>
  
  <div class="form-group row" >
       <button type="submit">Add Team</button>
      </div>
</form:form>
</div>
</div>
</c:otherwise>
</c:choose>




<!--Table  -->
<div class = "container col-sm-6" ng-app="myTeam" ng-controller="teamController">
<div id="teamDis" class="jumbotron">
Table
<table class="table table-bordered">
<tr>
<th>Team ID</th>
<th>Team Names</th>
<th>Team Image</th>
<th></th>
</tr>
  <tr ng-repeat="team in teams">
    <td>{{ team.teamId }}</td>
    <td>{{ team.teamName }}</td>
    <td><img src="./resources/{{team.teamId}}.jpg" height="50px" width="50px" /></td>
    <td>
    <a class="btn btn-default btn-xs" href="fetchTeam?teamId={{team.teamId}}"><span class="glyphicon glyphicon-pencil"></span></a>
 	<a class="btn btn-danger btn-xs" href="deleteTeam?teamId={{team.teamId}}"><i class="fa fa-trash-o" aria-hidden="true"></i></a>   
    </td>
  </tr>
</table>
</div>
</div>
<%@include file="AdminFooter.jsp" %>


