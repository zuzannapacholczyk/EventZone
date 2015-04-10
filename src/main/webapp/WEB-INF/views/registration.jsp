<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/resources/head.jsp" />
	
	<div class="Container">
		<h1 class="title">Registration </h1>
		
		<c:if test="${not empty registerFailureMsg}">
			<div style="margin: 30px 50px 0 50px" class="alert alert-danger" role="alert">
		    	<strong>Oh snap!</strong> <c:out value="${registerFailureMsg}"/>
		    </div>
		</c:if>
		<div class="line_divs">
			<div class="div_block1" id="register_form">
				<form:form modelAttribute="userForm" action="/EventZone/register/registerUser/" method="POST" >	
			 		<h2><form:label path="login" >Login</form:label></h2>
						<form:input path="login" required="true"/><br>
					<h2><form:label path="password">Password</form:label></h2>
						<form:input path="password" type="password" required="true"/><br>
					<h2><form:label path="name">Name</form:label></h2>
						<form:input path="name"/><br>
					<h2><form:label path="surname">Surname</form:label></h2>
						<form:input path="surname"/><br>
					<h2><form:label path="email" >Email</form:label></h2>
						<form:input path="email" required="true"/><br>
					<button id="submit_btn"  class="btn btn-large btn-success" type="submit">Register</button>
				</form:form>
			</div>
			<div id="register_msg">
				<h1>We're happy to have you here!</h1>
				<img style="width: 440px; height: 273px;" src="<c:url value="/resources/img/welcome.jpg" />">
			</div>
		</div>
	</div>
		
		
		
<jsp:include page="/resources/footer.jsp" />