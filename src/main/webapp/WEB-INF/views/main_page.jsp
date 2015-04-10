<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 
<body>
Welcome <c:out value="username"></c:out>!
<br/>
This is the main page!
<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
</body>
</html>