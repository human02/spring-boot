<html>
<head>
<title>Login Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Welcome to the Login page!</h1>

		<pre>${errorMessage}</pre>
		<!--Using method as post as it wont reveal sensitive info in the URL  -->
		<form method="post">
			Name: <input name="name" type="text"> Password: <input
				name="password" type="password"> <input type="submit">
		</form>
	</div>
	<script src="webjars/bootstrap/5.1.3/css/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>