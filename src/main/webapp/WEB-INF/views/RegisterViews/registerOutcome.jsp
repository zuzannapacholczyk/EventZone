
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
	
	<div class="Container">
		<c:choose>
			<c:when test="${success}">
		    	<c:out value="${successMsg}"/>
			</c:when>
		    <c:otherwise>
				<c:out value="${whyFailureMsg}"/>
			</c:otherwise>
		</c:choose>
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />