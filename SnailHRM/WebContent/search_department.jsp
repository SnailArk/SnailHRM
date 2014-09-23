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
	 <%@include file="./header.jsp" %>
	</div>
	<div id="container">
		<center>

			<div>
				Departments List(
				<s:property value="listDepartment.size" />
				)
			</div>
			<div>
				<a href="addDepartment">add</a>
			</div>
			<div>
				<table align='center' border='1'>
					<tr>
						<th>Department Name</th>
						<th>Notes</th>
					</tr>
					<s:iterator value='listDepartment'>
						<tr>
							<td><s:property value='departmentName' /></td>
							<td><s:property value='notes' /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</center>
	</div>
	<div id="footer">
		 <%@include file="./footer.jsp" %>
	
	</div>
</body>
</html>