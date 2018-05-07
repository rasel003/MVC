<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="helper.registrationCheck"%>

<!DOCTYPE html>
<html> 
	<body> 
		
		
		<% 
			
			if (session.getAttribute("loginOrNot") != null && session.getAttribute("loginOrNot").equals("yes")){
			
				out.println("Welcome mr. "+session.getAttribute("loggedUser"));
			}
			else {
				
				System.out.println("lgoin: "+session.getAttribute("loginOrNot"));
				System.out.println("Username: "+session.getAttribute("loggedUser"));
				
				System.out.println("homepage is null");
				response.sendRedirect("/login");
			}
		
		%>
		<br> <br>
		<a href="logOut"> <Button> Log Out </Button> </a>
		
		
	
	</body>
</html>