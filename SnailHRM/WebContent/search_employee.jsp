<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix='s' uri='/struts-tags'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./css/menu.css" rel="stylesheet" />
<script type="text/javascript" src="./js/jquery.js"></script>
<title>Snail Human Resource Management</title>
</head>
<body>
	<div id="header">
		<%@include file="./header.jsp"%>
	</div>
	<div id="container">
		<center>
		<div>
		<s:form action="searchEmployee">
		<table class="" align="center" style="width: 40%; overflow: hidden;">
		<tr><td><s:textfield name="employeeVO.firstName"
					label="First Name" maxlength="45" style="width: 50%;"/></td></tr>
					<tr><td><s:textfield name="employeeVO.lastName"
					label="Last Name" maxlength="45" style="width: 50%;"/></td></tr>
					<tr><td><s:submit name="submit" value="submit" align="center"></s:submit></td></tr>
		</table>
		</s:form>
		</div>
			<div id="searchBox">
				<div class=heading>
					<b><div style="padding: 7px;">
							Employees List (
							<s:property value="employeeList.size" />
							) <span style="margin: 317px;"></span> <a href="addEmployee">Add</a></b>
				</div>
			</div>
			<span style="padding: 1px;"></span>
			<table class="" align="center" style="width: 100%; overflow: hidden;">
				<tr>
					<th width="13%">First Name</th>
					<th width="13%">Middle Name</th>
					<th width="13%">Last Name</th>
					<th width="13%">Department</th>
 					<th width="13%">Role</th>
					<th width="13%">Date of Joining</th>
 					<th width="13%">Status</th>
				</tr>
				<s:iterator value='employeeList' status="rowstatus">
					<tr align="center"
						class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td width="40%"><a
							href="updateEmployee?id=<s:property value="id"/>"><s:property
									value='firstName' /></a></td>
						<td width="13%"><s:property value='middleName' /></td>
						<td width="13%"><s:property value='lastName' /></td>
						<td width="13%"><s:property value="department"/></td>
						<td width="13%"><s:property value='jobDetails' /></td>
						<td width="13%"><s:property value='role' /></td>
						<td width="13%"><s:property value='dateOfJoining' /></td>
						<td width="13%"><s:property value='status' /></td>
					</tr>
				</s:iterator>
			</table>
		</center>
	</div>

	<div id="footer">
		<%@include file="./footer.jsp"%>

	</div>
</body>
</html>