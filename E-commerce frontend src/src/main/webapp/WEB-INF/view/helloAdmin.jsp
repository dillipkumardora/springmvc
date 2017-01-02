
<%@ include file="header.jsp" %>

	<c:if test="${isAdminpage==true}">
		<h1>Welcome  Admin</h1>   <br><br>
		</c:if>
		<center>
		<ul>
		 <li>  <div class="supplier_button"><a href="<c:url value="suppliers"/>">Supplier</a></div></li>
		 <li>  <div class="product_button"><a href="<c:url value="products"/>">Product</a></div></li>
		 <li>  <div class="category_button"><a href="<c:url value="categories"/>">Category</a></div></li>
		 </ul>
				</center>		    		
						    
						    	 
		<c:if test="${isCategoryPage==true}">
		
		<%@ include file="category.jsp" %>
		</c:if>
		
		<c:if test="${isSupplierPage==true}">
		
		<%@ include file="supplier.jsp" %>
		</c:if>
		
		<c:if test="${isProductPage==true}">
		
		<%@ include file="product.jsp" %>
		</c:if>
		
		
<%@ include file="footer.jsp" %>
</body>
</html>