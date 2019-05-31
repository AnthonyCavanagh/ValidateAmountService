<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NHS </title>
</head>
<body>
	<h3>Welcome, Enter Amount and Frequency</h3>

	<form:form method="POST" action="${pageContext.request.contextPath}/addValidatedAmount" modelAttribute="regularAmount">
		<table>
		<tr>
				<td><form:label path="frequency">Frequency</form:label></td>
				<td>
				<form:select path="frequency">
				  <c:forEach var="freq" items="${frequencies}">
                        <option value="${freq}"></option>
                        <form:option value="${freq}">${freq}</form:option>
                    </c:forEach>
				</form:select>
                </td>
			</tr>
			<tr>
				<td><form:label path="amount">Amount</form:label></td>
				<td><form:input path="amount" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>

