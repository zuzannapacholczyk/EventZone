<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
	
	<div class="Container ">
		<h1 class="title">Registration </h1>
		<div class="line_divs">
			<div class="div_block1" id="register_form">
				
				<form method="post" >	
			 		<h2><label id="labels" for="user_name">Login</label></h2>
					<input type="text" id="user_name"><br>
					<h2><label for="user_password">Password</label></h2>
					<input type="text" id="user_password"><br>
					<h2><label for="name">Name</label></h2>
					<input type="text" id="name"><br>
					<h2><label for="surname">Surname</label></h2>
					<input type="text" id="surname"><br>
					<h2><label for="user_email">Email</label></h2>
					<input type="text" id="user_email"><br>
					<button id="submit_btn"  class="btn btn-large btn-success" type="submit">Register</button>
				</form>
			</div>
			<div id="register_msg">
				<h1>We're happy to have you here!</h1>
				<img style="width: 440px; height: 273px;" src="<c:url value="/resources/img/welcome.jpg" />">
			</div>
		</div>
	</div>
		
		
		
<jsp:include page="/resources/footer.jsp" />