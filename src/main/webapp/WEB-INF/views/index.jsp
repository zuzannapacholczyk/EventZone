<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />


 	<div class="Container">
 		<c:if test="${not empty successMsg}">
 			<div style="margin: 0px 50px" class="alert alert-success" role="alert">
		      <strong>Well done!</strong> Your account has been created! 
		      <br>You may login now.
		    </div>
		</c:if>
		<c:if test="${not empty error}">
			<div style="margin: 30px 50px 0 50px" class="alert alert-danger" role="alert">
		    	<strong>Oh snap!</strong> <c:out value="${error}"/>
		    </div>
		</c:if>
 	
 		<div id="login_and_create" class="line_divs">
	 		<div class="div_block1" id="standard_logging_form">
	 			<form method="post" id="login_form" action="<c:url value='j_spring_security_check' />">	
			 		<h2><label for="user_name">Login</label></h2>
					<input name="j_username" type="text" id="user_name"><br>
					<h2><label for="user_password">Password</label></h2>
					<input name="j_password" type="password" id="user_password"><br>
					<button id="submit_btn" class="btn btn-large btn-success" type="submit">Sign in</button>
				</form>
			</div>
			<div class="div_block1" id="acc_create">
				<h2>Welcome to EventZone!</h2>
				<p class="lead">Don't have an account?</p>
				<a class="btn btn-large btn-primary" href="<c:url value="/register/"  />">Create it now!</a>
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
 	
<jsp:include page="/resources/footer.jsp" />