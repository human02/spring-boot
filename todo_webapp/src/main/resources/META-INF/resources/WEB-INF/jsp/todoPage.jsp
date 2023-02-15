<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>To-Do List</title>
</head>
<body>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h1>Your To-Do</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Completed?</th>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetdate}</td>
						<td>${todo.done}</td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-success"> Update ${todo.id}</a></td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-warning"> Delete ${todo.id}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add a To-Do</a>
	</div>
	<script src="webjars/bootstrap/5.1.3/css/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>

</html>