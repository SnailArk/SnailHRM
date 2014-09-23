<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Snail Human Resource Management</title>

</head>
<body>
	<s:actionerror />
	<h2>Add department here</h2>
	<!--  Add department form -->
	<s:form action="addDepartment">
		<s:textfield name="departmentVO.departmentName"
			label="Department Name" />
		<s:textarea name="departmentVO.notes" label="Notes " rows="10" />
		<s:submit name="submit" value="submit" />
	</s:form>

</body>
</html>