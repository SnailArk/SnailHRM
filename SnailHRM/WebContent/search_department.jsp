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
			<div id="searchBox">
				<div class=heading>
					<b><div Style="padding: 7px;">
							Departments List (
							<s:property value="listDepartment.size" />
							) <span style="margin: 317px;"></span> <a href="addDepartment">add</a></b>
				</div>
			</div>
			<span style="padding: 1px;"></span>
			<table class="" align="center" style="width: 100%; overflow: hidden;">
				<tr>
					<th width="40%">Department Name</th>
					<th width="40%">Notes</th>
				</tr>
				<s:iterator value='listDepartment' status="rowstatus">
					<tr align="center"
						class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td width="40%"><a
							href="updateDepartment?id=<s:property value="id"/>"><s:property
									value='departmentName' /></a></td>
						<td width="40%"><s:property value='notes' /></td>
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