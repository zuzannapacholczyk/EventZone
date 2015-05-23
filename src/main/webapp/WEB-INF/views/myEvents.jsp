<!-- When creating new .jsp file just copy code at the bottom  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
	
	<div class="fixedElement">
		<nav class="navbar navbar-inverse" role="navigation">
		  <!-- Brand and toggle get grouped for better mobile display -->
		  <div class="navbar-header">
		    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
		      <span class="sr-only">Toggle navigation</span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		    </button>
		    <a class="navbar-brand" href="/EventZone/">EventZone</a>
		  </div>
		
		  <!-- Collect the nav links, forms, and other content for toggling -->
		  <div class="collapse navbar-collapse navbar-ex1-collapse">
		    <ul class="nav navbar-nav">
		      <li ><a href="<c:url value="/main" />">Home</a></li>
		      <li class="dropdown active">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Events<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="<c:url value="/main/event/create" />">Create an Event</a></li>
                  <li><a href="<c:url value="/listForOrganizer/" />">Manage my Events</a></li>
                  <li class="divider"></li>
                  <li><a href="#">Subscribe to an Event</a></li>
                  <li><a href="<c:url value="/listForParticipant/" />">Manage subscribed Events</a></li>
                </ul>
              </li>
              <li ><a href="#">My Tickets</a></li>
              <li class="divider"></li>
		      <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
		    </ul>
		  </div><!-- /.navbar-collapse -->
		</nav>
	</div>
	
	<div class="Container">
		
		<div class="top">
	      	<h2>Welcome <c:out value="${username}"></c:out>!
	      		This is the main page!
	      	</h2>
		</div>
		<br><br><br>
		<c:if test="${!empty listEventsForParticipant}">
		<% int i = 1; %>
		<c:forEach items="${listEventsForParticipant}" var="eventInfo">
		  <div class="row featurette">	  	
	        <div class="col-md-7 <% if(i % 2 == 0 ){out.println("col-md-push-5");} %>">
	          <h2 class="featurette-heading"><c:out value="${eventInfo.event.name}, ${eventInfo.event.dateOfEvent}"/><span class="text-muted"><c:out value=" ${eventInfo.event.place}"/></span></h2>
	          <p class="lead"><c:out value="${eventInfo.event.description}"/></p>
	        </div>
	        <div class="col-md-5 <% if(i % 2 == 0 ){out.println("col-md-pull-7");} %>">
	          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventone.jpg" />" data-holder-rendered="true">
	        </div>
	      </div>
	      <hr class="featurette-divider">
	      	  <% i++; %>
	      	</c:forEach>
	      </c:if>
	      
	      <!-- 
		      <div class="row featurette">
		        <div class="col-md-7 col-md-push-5">
		          <h2 class="featurette-heading">Event number two. <span class="text-muted">You need to come.</span></h2>
		          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
		        </div>
		        <div class="col-md-5 col-md-pull-7">
		          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventtwo.jpg"/>"  data-holder-rendered="true">
		        </div>
		      </div>
		      <hr class="featurette-divider">
		      <div class="row featurette">
		        <div class="col-md-7">
		          <h2 class="featurette-heading">Event number three. <span class="text-muted">It's gonna be good.</span></h2>
		          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
		        </div>
		        <div class="col-md-5">
		          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500" src="<c:url value="/resources/img/events/eventthree.png"/>"  data-holder-rendered="true">
		        </div>
		      </div>
		      <hr class="featurette-divider">
	      -->
	      
	      <!-- organizer part -->
	      <c:if test="${!empty listEventsForOrganizer}">
		<c:forEach items="${listEventsForOrganizer}" var="eventInfo">
		<hr class="featurette-divider">
		  <div class="row featurette">	  	
	        <div class="col-md-7">
	          <h2 class="featurette-heading"><c:out value="${eventInfo.name}"/><span class="text-muted"><c:out value="${eventInfo.subtitle}"/></span></h2>
	          <h2 class="featurette-heading"><c:out value="${eventInfo.event.place}"/><span class="text-muted"><c:out value="${eventInfo.event.dateOfEvent}"/></span></h2>
	          <p class="lead"><c:out value="${eventInfo.description}"/></p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventone.jpg" />" data-holder-rendered="true">
	        </div>
	      </div>
	      	</c:forEach>
	      </c:if>
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />