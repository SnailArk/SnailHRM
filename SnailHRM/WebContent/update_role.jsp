<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

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
		<div id="addBox">
			<div class="heading">
				<b><div Style="padding: 9px;">Update role here</div></b>
			</div>
			<s:actionerror />
			<!--  Update role form -->
			<s:form action="updateRole">
				<s:hidden name = "roleVO.id"/>
				<s:textfield name="roleVO.roleName" label="Role Name" />
				<s:textarea name="roleVO.roleDescription" label="Description " rows="10" />
				<s:submit name="submit" value="submit" />
			</s:form>
		</div>	
		</center>
	</div>
	<div id="footer">
		<%@include file="./footer.jsp"%>
	</div>
</body>
</html>