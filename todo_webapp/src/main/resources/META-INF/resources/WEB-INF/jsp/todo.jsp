<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Add To-Do</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		
</head>
<body>
	<div class="container">
		<h1>Enter To-Do Details</h1>
		<!-- Here we do model binding using spring tags -->
		<form:form method="post" modelAttribute="todo">
			 <form:input path="id" type="hidden"/> 
			Description: <form:input path="description" required="required"/> 
			<form:errors path="description" cssClass="text-warning"/>
			 <form:input path="done" type="hidden"/> 
			<!-- Above required prevents adding empty value but hackers can misuse it hence use server side validation -->
			<input type="submit" class="btn btn-success"/>
			<input type="reset" class="btn btn-danger"/>
		</form:form>
	</div>
	<script src="webjars/bootstrap/5.1.3/css/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>