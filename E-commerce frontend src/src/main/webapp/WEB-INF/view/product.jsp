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
<title>Insert title here</title>
</head>
<body>

<center>
		<div class="container">
			<h1>Add a Product</h1>
			<br>

			<c:url var="addAction" value="/product/add"></c:url>

			<form:form action="${addAction}" commandName="product">
				
				<table>
					<tr>
						<td align="left"><form:label path="id">
								<spring:message text="1. ID" />
							</form:label></td>
						<c:choose>
							<c:when test="${!empty product.id}">
								<td><form:input path="id" disabled="true"
										readonly="true" /></td>
							</c:when>

							<c:otherwise>
								<td align="left"><form:input path="id"
										patttern=".{6,7}" required="true"
										title="id should contains 6 to 7 characters" /></td>
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
						<td align="left"><form:input path="name"
								required="true" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left"><form:label path="description">
								<spring:message text="3. Description" />
							</form:label></td>
						<td align="left"><form:input path="description"
								required="true" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left"><form:label path="price">
								<spring:message text="4. Price" />
							</form:label></td>
						<td align="left"><form:input path="price" required="true" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left"><form:label path="supplier">
								<spring:message text="5. Supplier" />
							</form:label></td>
						<%-- <td><form:input path="supplier.name" required="true" /></td> --%>
						<td align="left"><form:select path="supplier.name"
								items="${supplierList}" itemValue="name" itemLabel="name" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="left"><form:label path="category">
								<spring:message text="6. Category" />
							</form:label></td>
						<%-- <td><form:input path="category.name" required="true" /></td> --%>
						<td align="left"><form:select path="category.name"
								items="${categoryList}" itemValue="name" itemLabel="name" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					
				
					<tr>
						<td align="left" colspan="2"><c:if
								test="${!empty product.name}">
								<input type="submit"
									value="<spring:message text="Edit product"/>" />
							</c:if> <c:if test="${empty product.name}">
								<input type="submit"
									value="<spring:message text="Add Product"/>" />
							</c:if></td>
					</tr>
				</table>
			</form:form>
			<br>
			<h3>Product List</h3>
			<br>
			<c:if test="${!empty productList}">
				<table border="1px solid black">
					<tr>
						<th width="80">Product ID</th>
						<th width="120">Product Name</th>
						<th width="200">Product Description</th>
						<th width="80">Price</th>
						<th width="80">Product Category</th>
						<th width="80">Product Supplier</th>
						<th width="60">Edit</th>
						<th width="60">Delete</th>
					</tr>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.description}</td>
							<td>${product.price}</td>
							<td>${product.category.name}</td>
							<td>${product.supplier.name}</td>
							<td><a
								href="<c:url value='product/edit/${product.id}' />">Edit</a></td>
							<td><a
								href="<c:url value='product/remove/${product.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</center>

</body>
</html>