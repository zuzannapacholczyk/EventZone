<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
<link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="resources/css/bootstrap-social.css" />" rel="stylesheet" type="text/css">

<link href="<c:url value="resources/css/font-awesome.css" />" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery.js"></script>

 	<div class="loginContainer">
 		<div id="standard_loging_form">
 			<form>	
		 		<h2><label id="labels" for="user_name">Login:</label></h2>
				<input name="j_username" type="text" id="user_name"><br>
				<h2><label for="user_password">Password:</label></h2>
				<input name="j_password" type="text" id="user_password">
			</form>
		</div>
		<div id="other_logging_providers">
			<span id="buttons">
				<button class="btn btn-large btn-google-plus">
					<i class="fa fa-google-plus"></i>
					 | Connect with Google Plus
				</button>
			</span>
			<br>
			<span id="buttons">
			  	<button class="btn btn-large btn-facebook">
			  		<i class="fa fa-facebook"></i>
			  		 | Connect with Facebook
			  	</button>
		  	</span>
		</div>
 	</div>
 	<div id="page_footer">
 	
 	</div>

</body>
</html>