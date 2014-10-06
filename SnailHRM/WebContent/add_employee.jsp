<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./css/menu.css" rel="stylesheet" />
<link href="./css/jquery-ui.css" rel="stylesheet">
<script src="./js/jquery-1.11.1.js"></script>
<script src="./js/jquery-ui.js"></script>

<script>
	$(function() {
		$("#datepicker-13").datepicker();
		$("#datepicker-13").datepicker("show");
	});
	$(function() {
		$("#datepicker-12").datepicker();
		$("#datepicker-12").datepicker("show");
	});
</script>

<title>Snail Human Resource Management</title>
</head>
<body>
	<div id="header">
		<%@include file="./header.jsp"%>
	</div>
	<div id="container">
		<center>
			<div id="addBox">
				<div class="heading centertext">
					<b><div Style="padding: 9px;">Add Employee here</div></b>
				</div>
				<s:actionerror />
				<!--  Add Employee form -->
				<s:form action="addEmployee">
					<table>
						<tr align="left" class="centertext">
							<th><h3>
									<font color="#707070"><strong>Personal Details</strong></font>
								</h3></th>
						</tr>

						<tr>
							<td><s:textfield name="employeeVO.firstName"
									label="First Name" /></td>
						</tr>
						<tr>
							<td><s:textfield name="employeeVO.middleName"
									label="Middle Name" /></td>
						</tr>
						<s:textfield name="employeeVO.lastName" label="Last Name" />
						<tr>
							<td><s:textfield name="employeeVO.dateOfBirth"
									label="Date Of Birth" id="datepicker-13" /></td>

						</tr>
						<tr>
							<td><s:textfield name="employeeVO.nationality"
									label="Nationality" /></td>
						</tr>
						<tr>
							<td><s:radio label="Gender" name="employeeVO.gender"
									list="{'Male','Female'}" /></td>
						</tr>
						<tr>
							<td><s:textfield name="employeeVO.phoneNumber"
									label="Contact Number" /></td>
						</tr>
						<tr>
							<td><s:textfield name="employeeVO.email" label="Email Id" /></td>
						</tr>
					</table>

					<hr />

					<table>
						<tr align="left" class="centertext">
							<th>
								<h3>
									<font color="#707070"><strong>Address details</strong></font>
								</h3>
							</th>
						</tr>
						<tr>
							<td align="left">
								<h4>
									<font color="#707000"><strong>Permanent Address
									</strong></font>
								</h4>
							</td>
						</tr>
						<tr>
							<td><s:textarea name="permanentAddressVO.street"
									label="Street" /></td>
						</tr>
						<tr>
							<td><s:select name="permanentAddressVO.city" label="City"
									list="{'jodhpur','jaipur'}" /></td>
						</tr>
						<tr>
							<td><s:select name="permanentAddressVO.state" label="State"
									list="{'Delhi','Rajasthan'}" /></td>
						</tr>
						<tr>
							<td><s:select name="permanentAddressVO.country"
									label="Country" list="{'India','USA'}" /></td>
						</tr>
						<tr>
							<td align="left">
								<h4>
									<font color="#707000"><strong>Communication
											Address </strong></font>
								</h4>
							</td>
						</tr>
						<tr>
							<td><s:textarea name="communicationAddressVO.street"
									label="Street" /></td>
						</tr>
						<tr>
							<td><s:select name="communicationAddressVO.city"
									label="City" list="{'jodhpur','jaipur'}" /></td>
						</tr>
						<tr>
							<td><s:select name="communicationAddressVO.state"
									label="State" list="{'Delhi','Rajasthan'}" /></td>
						</tr>
						<tr>
							<td><s:select name="communicationAddressVO.country"
									label="Country" list="{'India','USA'}" /></td>
						</tr>
					</table>

					<hr />

					<table>
						<tr align="left" class="centertext">
							<th><h3>
									<font color="#707070"><strong>Job details</strong></font>
								</h3></th>
						</tr>

						<tr>
							<td><s:select name="jobVO.department.id" label="Department"
									list="departmentOptionList" listKey="value" listValue="label" />
							</td>
						</tr>

						<tr>
							<td><s:select name="jobVO.role.id" label="Role"
									list="roleOptionList" listKey="value" listValue="label" /></td>
						</tr>

						<tr>
							<td><s:textfield name="jobVO.dateOfJoining"
									label="dateOfJoining" id="datepicker-12" /></td>
						</tr>
					</table>
					<hr />
					<s:submit name="submit" value="submit" />
				</s:form>
			</div>
		</center>
	</div>

</body>
</html>