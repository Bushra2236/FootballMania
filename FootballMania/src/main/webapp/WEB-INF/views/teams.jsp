<%@include file="CommonHeader.jsp"%>

<script>

var teamDisplay = ${display};
</script>



<div class= "container">
<div ng-controller="teamController">
<div id="teamDis" class="jumbotron">
<table class="table table-bordered">
<tr>
<td>Team Name</td>
<td>Team Image</td>
</tr>
  <tr ng-repeat="team in teams">
    <td>{{team.teamName}}</td>
    <td><img src="./resources/{{team.teamId}}.jpg" height="50px" width="100px" /></td>
  </tr>
</table>
</div>
</div>
 
 </div>
 
<%@include file="CommonFooter.jsp"%>