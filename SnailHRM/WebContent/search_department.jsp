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
					<b><div Style="padding: 9px;">
							Departments List (
							<s:property value="listDepartment.size" />
							) <span style="margin: 317px;"></span> <a href="addDepartment">add</a></b>
				</div>
			</div>
		<span style="padding: 1px;"></span>	
		<table class="heading" align="center" style=" width : 100%; overflow: hidden;">
			<tr>
				<th width="40%">Department Name</th>
				<th width="40%">Notes</th>
				<th width="20%">Action</th>
			</tr>
			<s:iterator value='listDepartment' status="rowstatus">
				<tr class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>" >
					<td width="40%" ><s:property value='departmentName' /></td>
					<td width="40%" ><s:property value='notes' /></td>
					<td width="20%" ><a href="updateDepartment?id=<s:property value="id"/>"><img src="./images/edit_img.png"></a></td>
				</tr>
			</s:iterator>
		</table>

		<%-- 		
			<div id="searchBox">
				<div class=heading>
					<b><div Style="padding: 9px;">
							Departments List(
							<s:property value="listDepartment.size" />
							) <span style="margin: 317px;"></span> <a href="addDepartment">add</a></b>
				</div>
			</div>


			<div>
				<b>Department Name</b><span class="columnSpace"></span><b>Notes</b><span
					class="columnSpace"></span><b>Action</b>
			</div>

			<s:iterator value='listDepartment' status="rowStatus">
				<div class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>" >
								
					<s:property value='departmentName' />
					<span class="columnSpaceData"></span>
					<s:property value='notes' />
					<span class="columnSpaceData"></span> 
				</div>
			
			</s:iterator>
 
	</div>
	</div>
--%>	</center>
	</div>

	<div id="footer">
		<%@include file="./footer.jsp"%>

	</div>
</body>
</html>