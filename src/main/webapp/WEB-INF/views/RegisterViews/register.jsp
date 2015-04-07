<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
	
	<div class="Container ">
		<h1 class="title">Registration </h1>
		<div class="line_divs">
			<div class="div_block1" id="register_form">
				
				<form action="<c:url value="registerUser/" />" method="post" enctype="application/json">	
			 		<h2><label id="labels" for="login">Login</label></h2>
					<input type="text" name="login"><br>
					<h2><label for="password">Password</label></h2>
					<input type="text" name="password"><br>
					<h2><label for="name">Name</label></h2>
					<input type="text" name="name"><br>
					<h2><label for="surname">Surname</label></h2>
					<input type="text" name="surname"><br>
					<h2><label for="email">Email</label></h2>
					<input type="text" name="email"><br>
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