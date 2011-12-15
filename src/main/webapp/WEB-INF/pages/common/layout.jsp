<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge;chrome=1" />
		<meta name="google-site-verification" content="" />
		<meta name='yandex-verification' content='' />
		<meta name="copyright" content="Copyright 2011 - JavaToday.co" />
		<meta name="description" content="A community of java developers: The future is built by those who can see what's not yet there." />
		<meta name="keywords" content="java, jvm, developer, developers, java developer, java community, java today, javatoday" />
	
		<meta name="author" content="Artur Mkrtchyan, Grigor Martirosyan" />
		<meta name="robots" content="index, follow" />
		<meta name="revisit-after" content="7" />
		<meta name="language" content="English" />
		
		<title>Welcome - JavaToday.co</title>
		
		<link href="<c:url value="/resources/images/icons/favicon.ico" />" rel="shortcut icon"/>
	
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/normalize.css" />" media="all"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/global.css" />" media="all"/>
		
		<script src="https://ajax.googleapis.com/ajax/libs/mootools/1.4.1/mootools-yui-compressed.js"></script>
		<script src="http://maps.google.com/maps/api/js?sensor=true" type="text/javascript"></script>
		<script src="<c:url value="/resources/scripts/global.js" />"></script>
		<!--[if lt IE 9]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	</head>

	<body>
	
		<div id="container">
			
			<!--  header -->
			<tiles:insertAttribute name="header"/>
			
			<!-- main central container -->
			<tiles:insertAttribute name="body"/>
	    		
			<!-- footer -->
			<tiles:insertAttribute name="footer"/>
			
		</div>
	
	</body>
</html>