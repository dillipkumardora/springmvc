
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    



    
<!DOCTYPE HTML>
<html>
<head>
<title>HomePage</title>
 <link href="<c:url value="resources/css/bootstrap.css"  />" rel="stylesheet">
 <link href="<c:url value="resources/css/style.css"  />" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<script src="<c:url value="resources/js/jquery.min.js" />"></script>
<!--<script src="js/jquery.easydropdown.js"></script>-->
<!--start slider -->
 <link href="<c:url value="resources/css/fwslider.css" />" rel="stylesheet">
  <script src="<c:url value="resources/js/jquery-ui.min.js" />"></script>
  <script src="<c:url value="resources/js/fwslider.js" />"></script>
 

<!--end slider -->
<script type="text/javascript">
        $(document).ready(function() {
            $(".dropdown img.flag").addClass("flagvisibility");

            $(".dropdown dt a").click(function() {
                $(".dropdown dd ul").toggle();
            });
                        
            $(".dropdown dd ul li a").click(function() {
                var text = $(this).html();
                $(".dropdown dt a span").html(text);
                $(".dropdown dd ul").hide();
                $("#result").html("Selected value is: " + getSelectedValue("sample"));
            });
                        
            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function(e) {
                var $clicked = $(e.target);
                if (! $clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function() {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });
        });
     </script>
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="row">
			  <div class="col-md-12">
				 <div class="header-left">
					 <div class="logo">
						<a href="<c:url value="home"/>"><img src="resources/images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						  <a class="toggleMenu" href="#"><img src="resources/images/nav.png" alt="" /></a>
						    <ul class="nav" id="nav">
						   <li>  <div class="home_button"><a href="<c:url value="/"/>">Home</a></div></li>
						  
						    	 	 <p class="log">
						    	 <ul>
						    	 
						    	 	<c:if test="${pageContext.request.userPrincipal.name==null}">
						    
						    	
						    	 	<a href="<c:url value="login"/>">Login</a>
						    	 	</c:if>
						    	 	
						    	 	<c:if test="${pageContext.request.userPrincipal.name!=null}">
						    	 	<lib> <a>Welcome:${pageContext.request.userPrincipal.name}</a><lib>
						    	 	<lib><a href="<c:url value="/logout"/>">Logout</a></lib>
						    	 	</c:if>
						    	 
						    	
						    	 </ul>
						    	 
						    	 </p>
						    	
						  
						    	
															
								<div class="clear"></div>
							</ul>
							
							<script src="<c:url value="resources/js/responsive-nav.js" />"></script>
				    </div>							
	    		    <div class="clear"></div>
	    	    </div>
	            <div class="header_right">
	    		  <!-- start search-->
				      <div class="search-box">
							<div id="sb-search" class="sb-search">
								<form>
									<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
									<input class="sb-search-submit" type="submit" value="">
									<span class="sb-icon-search"> </span>
								</form>
							</div>
						</div>
						<!----search-scripts---->
						<script src="<c:url value="resources/js/classie.js" />"></script>
						<script src="<c:url value="resources/js/uisearch.js" />"></script>
					
					<script>
					new UISearch( document.getElementById( 'sb-search' ) );
					</script>
							
					
					
	       </div>
	      </div>
		 </div>
	    </div>
	</div>
	