<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<footer>
		<div id="copyright"> Copyright &copy; 2011 JavaToday.co, All rights reserved.</div>
	</footer>
<pre>
Debug:
<c:forEach var="debugEntry" items="${debugData}">
	${debugEntry.key}  = ${debugEntry.value}
</c:forEach>
</pre>