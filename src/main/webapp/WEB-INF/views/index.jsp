<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />


 	<div class="Container">
 		<c:if test="${not empty successMsg}">
 			<div style="margin: 0px 50px" class="alert alert-success" role="alert">
		      <p class="lead"><strong>Well done!</strong> Your account has been created!</p> 
		      <br><span class="lead">You may login now.</span>
		    </div>
		</c:if>
		<c:if test="${not empty error}">
			<div style="margin: 30px 50px 0 50px" class="alert alert-danger" role="alert">
		    	<p class="lead"><strong>Oh snap!</strong> <c:out value="${error}"/></p>
		    </div>
		</c:if>
 	
 		<div id="login_and_create" class="line_divs">
	 		<div class="div_block1" id="standard_logging_form">
	 			<form method="post" id="login_form" action="<c:url value='j_spring_security_check' />">	
			 		<div class="form-group">
                        <label for="user_name" class="lead control-label">Username</label>
                        <input type="text" class="form-control" id="user_name" name="j_username" required="true" title="Please enter you username" ></input>
                        <span class="help-block"></span>
                    </div>
                    <div class="form-group">
                        <label for="user_password" class="lead control-label">Password</label></h3>
                        <input type="password" class="form-control" id="user_password" name="j_password" required="true" title="Please enter you username"></input>
                        <span class="help-block"></span>
                    </div>
					<button id="submit_btn" class="btn btn-lg btn-success btn-block" type="submit">Sign in</button>
				</form>
			</div>
			<div class="div_block1" id="acc_create">
				<h2>Welcome to EventZone!</h2>
				<p style="margin-bottom: 20px;" class="lead">Don't have an account?</p>
				<a class="btn btn-lg btn-primary" href="<c:url value="/register/"  />">Create it now!</a>
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