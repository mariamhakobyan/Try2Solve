<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- main central container -->
<section id="content" class="cf">
	<c:if test="${not empty loggedInUser}">
	 	<c:out value="${loggedInUser.name}"/>
	</c:if>
	<!-- ajax loader -->
	<div id="loader"></div>
	<section id="articles" class="cf">
		Content
	</section>
	
	
</section>
<!-- end of main central container -->
