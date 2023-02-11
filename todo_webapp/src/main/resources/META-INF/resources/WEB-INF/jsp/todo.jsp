<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Add To-Do</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet">

</head>
<body>
	<div class="container">
		<h1>Enter To-Do Details</h1>
		<!-- Here we do model binding using spring tags -->
		<form:form method="post" modelAttribute="todo">
			<form:input path="id" type="hidden" />
			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input path="description" required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetdate">Target Date</form:label>
				<form:input path="targetdate" required="required" />
				<form:errors path="targetdate" cssClass="text-warning" />
			</fieldset>

			<!-- required field prevents adding empty value but hackers can misuse it hence use server side validation -->
			<fieldset class="mx-auto px-auto">
				<input type="submit" class="btn btn-success" /> <input type="reset"
					class="btn btn-danger" />
			</fieldset>
		</form:form>
	</div>
	<script src="webjars/bootstrap/5.1.3/css/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<!-- We got it from the bootstrap picker website in the usage section and changed the id to #targetdate -->
	<script type="text/javascript">
		$('#targetdate').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>
</body>
</html>