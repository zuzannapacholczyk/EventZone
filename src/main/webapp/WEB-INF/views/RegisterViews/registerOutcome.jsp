
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
	
	<div class="Container browser-spec">
		<c:choose>
			<c:when test="${success}">
				<div class="div_block1 hero-unit">
					<h2>
						<c:out value="${successMsg}"/>
					</h2>
					<p><button id="submit_btn" class="btn btn-primary right" onclick="location.href='/EventZone/';">Main Page</button>
					</p>
				</div>
			</c:when>
		    <c:otherwise>
		    	<div class="div_block1 hero-unit">
					<h2>
						<c:out value="${whyFailureMsg}"/>
					</h2>
					<p><button id="submit_btn" class="btn btn-warning right" onclick="location.href='/EventZone/';">Main Page</button>
					</p>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />