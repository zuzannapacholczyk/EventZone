<!-- When creating new .jsp file just copy code at the bottom  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
	
	<div class="Container">
		<div class="">
		 <nav class="navbar navbar-inverse">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">EventZone</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </nav>
      	<br><br>
      	<h2>Welcome <c:out value="${username}"></c:out>!
      		This is the main page!
			<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
      	</h2>
		</div>
		  <hr class="featurette-divider">
		  <div class="row featurette">	  	
	        <div class="col-md-7">
	          <h2 class="featurette-heading">Event number one. <span class="text-muted">It'll be fun.</span></h2>
	          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventone.jpg" />" data-holder-rendered="true">
	        </div>
	      </div>
	      <hr class="featurette-divider">
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
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />