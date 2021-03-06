<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>category page</title>
</head>
<body>
<center>
		<div class="container">
			<h1>Add a Category</h1>
			<br>

			<c:url var="addAction" value="/category/add"></c:url>

			<form:form action="${addAction}" commandName="category">
				<table>
					<tr>
						<td align="left"><form:label path="id">
								<spring:message text="1. ID" />
							</form:label></td>
						<c:choose>
							<c:when test="${!empty category.id}">
								<td><form:input path="id" disabled="true"
										readonly="true" /></td>
							</c:when>

							<c:otherwise>
								<td align="left"><form:input path="id" patttern=".{6,7}"
										required="true" title="id should contains 6 to 7 characters" /></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<form:input path="id" hidden="true" />
						<td align="left"><form:label path="name">
								<spring:message text="2. Name" />
							</form:label></td>
						<td align="left"><form:input path="name" required="true" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left"><form:label path="description">
								<spring:message text="3. Description" />
							</form:label></td>
						<td align="left"><form:input path="description" required="true" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left" colspan="2"><c:if test="${!empty category.name}">
								<input type="submit"
									value="<spring:message text="Edit Category"/>" />
							</c:if> <c:if test="${empty category.name}">
								<input type="submit"
									value="<spring:message text="Add Category"/>" />
							</c:if></td>
					</tr>
				</table>
			</form:form>
			<br>

<h3>Category List</h3>
			<br>
			<c:if test="${!empty categoryList}">
				<table border="1px solid black">
					<tr>
						<th width="80">Category ID</th>
						<th width="120">Category Name</th>
						<th width="120">Category Description</th>
						<th width="60">Edit</th>
						<th width="60">Delete</th>
					</tr>
					<c:forEach items="${categoryList}" var="category">
						<tr>
							<td>${category.id}</td>
							<td>${category.name}</td>
							<td>${category.description}</td>
							<td><a
								href="<c:url value='category/edit/${category.id}' />">Edit</a></td>
							<td><a
								href="<c:url value='category/remove/${category.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
</center>
<%@ include file="footer.jsp" %>
</body>
</html>