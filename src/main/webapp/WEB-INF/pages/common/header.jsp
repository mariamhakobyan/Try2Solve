<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<header class="cf">
	<h1 class="logo">
		<a title="home" href="<c:url value="/" />">Java Today</a>
	</h1>
	<nav>
		<ul id="main-menu">
			<li class="on"><a href="<c:url value="/" />"><spring:message code="menu.home"/></a></li>
			<li class="bull">&bull;</li>

			<li><a href="" title="articles"><spring:message code="menu.articles"/></a></li>
			<li class="bull">&bull;</li>
			
			<li><a href="" title="videos"><spring:message code="menu.videos"/></a></li>
			<li class="bull">&bull;</li>
			
			<li><a href="" title="questions"><spring:message code="menu.questions"/></a></li>
			<li class="bull">&bull;</li>

			<li><a href="" title="challenges"><spring:message code="menu.challenges"/></a></li>
			<li class="bull">&nbsp;</li>
			
			<c:choose>
				<c:when test="${not empty loggedInUser}">
					<li class="login logged">
						<a id="user-profile" href="#" title="" class="cf">
							<img src="images/avatar.jpg" title="Grigori Martirosyan" alt="Grigori Martirosyan" height="24" />
							<span>Grigori Martirosyan</span>
							<span class="icon">&nbsp;</span>
						</a>
						<ul id="user-dropdown" class="hidden">
							<li><a href="#">Profile</a></li>
							<li><a href="#">Settings</a></li>
							<li><a href="<c:url value="/logout" />" title="logout">Logout</a></li>
						</ul>
					</li>
				</c:when>
				<c:otherwise>
					<li class="login"><a href="<c:url value="/login" />" title="login">Login</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</header>