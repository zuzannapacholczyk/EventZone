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
			 		<div class="form-group">
                        <form:label path="login" for="login" class="lead control-label">Username</form:label>
                        <form:input path="login" type="text" class="form-control" id="login" name="login" required="true" ></form:input>
                        <span class="help-block"></span>
                    </div>
                    <div class="form-group">
                        <form:label path="password" for="password" class="lead control-label">Password</form:label>
                        <form:input path="password" type="password" class="form-control" id="password" name="password" required="true"></form:input>
                        <span class="help-block"></span>
                    </div>
                    <div class="form-group">
                        <form:label path="name" for="name" class="lead control-label">Name</form:label>
                        <form:input path="name" type="text" class="form-control" id="name" name="name"  ></form:input>
                        <span class="help-block"></span>
                    </div>
                    <div class="form-group">
                        <form:label path="surname" for="surname" class="lead control-label">Surname</form:label>
                        <form:input path="surname" type="text" class="form-control" id="surname" name="surname" ></form:input>
                        <span class="help-block"></span>
                    </div>
					<div class="form-group">
                        <form:label path="email" for="email" class="lead control-label">Email</form:label>
                        <form:input path="email" type="text" class="form-control" id="email" name="email" required="true" ></form:input>
                        <span class="help-block"></span>
                    </div>
					
					<button id="submit_btn"  class="btn btn-lg btn-success btn-block" type="submit">Register</button>
				</form:form>
			</div>
			<div id="register_msg">
				<h1>We're happy to have you here!</h1>
				<img style="width: 440px; height: 273px;" src="<c:url value="/resources/img/welcome.jpg" />">
			</div>
		</div>
	</div>
		
		
		
<jsp:include page="/resources/footer.jsp" />