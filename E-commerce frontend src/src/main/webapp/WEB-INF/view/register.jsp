<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@ include file="header.jsp" %>
						<!----search-scripts---->
						
						
						  <script src="<c:url value="resources/js/classie.js" />"></script>
 							 <script src="<c:url value="resources/js/uisearch.js" />"></script>
					
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
				     <ul class="icon1 sub-icon1 profile_img">
					 <li><a class="active-icon c1" href="#"> </a>
						<ul class="sub-icon1 list">
						  <div class="product_control_buttons">
						  	<a href="#"><img src="resources/images/edit.png" alt=""/></a>
						  		<a href="#"><img src="resources/images/close_edit.png" alt=""/></a>
						  </div>
						   <div class="clear"></div>
						  <li class="list_img"><img src="resources/images/1.jpg" alt=""/></li>
						  <li class="list_desc"><h4><a href="#">velit esse molestie</a></h4><span class="actual">1 x
                          $12.00</span></li>
						  <div class="login_buttons">
							  <div class="check_button"><a href="<c:url value="checkout"/>">Check out</a></div>
							 <div class="login_button"><a href="<c:url value="login"/>">Login</a></div>
							 <div class="clear"></div>
						  </div>
						  <div class="clear"></div>
						</ul>
					 </li>
				   </ul>
		        <div class="clear"></div>
	       </div>
	      </div>
		 </div>
	    </div>
	  </div>
     <div class="main">
      <div class="shop_top">
	     <div class="container">
						<form method="post" action="registeruser"> 
								<div class="register-top-grid">
										<h3>PERSONAL INFORMATION</h3>
										
										<div>
							<label for="id">UserId</label> <input type="text"name="id" pattern=".{5,8}" id=" username"spellcheck="false" 	placeholder="Id must be 5 to 8 Character" 
								
								class="form-control" required/>
										</div>
										
										<div>
							<label for="name">UserName</label> <input type="text"name="name" pattern=".{8,15}" id=" username"spellcheck="false" 	placeholder="Username" 
								
								class="form-control" required/>
										</div>

							<div>
							<label  for="email">Email</label> <input type="email" 
							id="email" spellcheck="false" name="email"placeholder="abc@xyz.com" class="form-control" required/>
							</div>
							
							<div>
								<label  for="mobile">Mobile</label> <input type="tel" 	name="mobile" pattern="[7|8|9][0-9]{9}$" 	title="Please enter valid mobile number" 
								placeholder=" Enter Mobile Number" id="mobile" spellcheck="false" class="form-control" required/>
							
							</div>

									
										
										<div class="clear"> </div>
								</div>
								<div class="clear"> </div>
								<div class="register-bottom-grid">
										
										<div>
							<label  for="password">Password</label> <input type="password"
								name="password" id="password" pattern=".{5,15}"
									title="password should contains 5 to 15 characters"
							placeholder="********" class="form-control" required/>
				
						</div>
										<div>
							<label  for="repassword">Confirm Password</label> <input
								type="password" name="repassword" id="repassword"
								pattern=".{5,15}"
								title="password should contains 5 to 15 characters"
								placeholder="********" class="form-control" required/>


						</div>
										<div class="clear"> </div>
								</div>
								<div class="clear"> </div>
								<input type="submit" value="submit">
						</form>
					</div>
		   </div>
	  </div>
	
<%@ include file="footer.jsp" %>
</body>	
</html>