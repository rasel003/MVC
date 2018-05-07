<!DOCTYPE html>
<html>
	<head>
		<title>Log In Page</title>
	</head>
	<body>
		
		<% 	
			if (session.getAttribute("loginOrNot") != null && session.getAttribute("loginOrNot").equals("yes")){
			
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
					rd.forward(request, response); 
			}
			
		%>
		<div align="center">
			<h3> Sign In </h3>
			<form action="loginController" method="post">
				Enter username : <input type="text" name="username"> <br><br>
				Enter password : <input type="password" name="password"> <br><br>
				<input type="submit" value="Log In"/>
			</form>
		</div>
	</body>
</html>