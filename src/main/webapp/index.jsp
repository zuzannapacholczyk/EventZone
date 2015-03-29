<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
<link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="resources/css/bootstrap-social.css" />" rel="stylesheet" type="text/css">

<link href="<c:url value="resources/css/font-awesome.css" />" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery.js"></script>

 	<div class="loginContainer">
 		<div id="login_and_create" class="line_divs">
	 		<div class="div_block1" id="standard_logging_form">
	 			<form method="post" id="login_form">	
			 		<h2><label id="labels" for="user_name">Login</label></h2>
					<input name="j_username" type="text" id="user_name"><br>
					<h2><label for="user_password">Password</label></h2>
					<input name="j_password" type="text" id="user_password"><br>
					<button class="btn btn-large btn-success" type="submit">Sign in</button>
				</form>
			</div>
			<div class="div_block1" id="acc_create">
				<h2>Don't have an account?</h2>
				<button class="btn btn-large btn-primary" >Create it now!</button>
			</div>
		</div>
		
		<div class="div_block1" id="other_logging_providers">
			<h3>Don't want to create an account?</h3>
			<div id="buttons">
				<button class="btn btn-large btn-google-plus">
					<i class="fa fa-google-plus"></i>
					 | Connect with Google Plus
				</button>
			</div>
			<br>
			<div id="buttons">
			  	<button class="btn btn-large btn-facebook">
			  		<i class="fa fa-facebook"></i>
			  		 | Connect with Facebook
			  	</button>
		  	</div>
		</div>
 	</div>
 	<div id="page_footer">
 	
 	</div>

</body>
</html>