<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="helper.registrationCheck"%>

<!DOCTYPE html>
<html> 
	<body> 
				
		<% 
			 RequestDispatcher rd=null;
			session.setAttribute( "loggedUser", null );
			session.setAttribute( "loginOrNot", null);
			
			rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			rd.forward(request,response); 
			//response.sendRedirect("/WEB-INF/view/login.jsp");
		
		%>
			
	</body>
</html>