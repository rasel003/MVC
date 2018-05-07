<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="helper.registrationCheck"%>

<!DOCTYPE html>
<html> 
	<body> 
		
		<jsp:useBean id="check" class="helper.registrationCheck" scope="session" />
		<jsp:setProperty name="check" property="name" value='<%= request.getParameter("name") %>' />
		<jsp:setProperty name="check" property="email" value='<%= request.getParameter("email") %>' />
 		
		<% String name = check.getName(); String email = check.getEmail();
		   
		   if(name == null || email==null || name.length()<3 || email.length()<3){
			   
			  //response.sendRedirect("/WEB-INF/view/registration.html");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/registration.html");
				rd.forward(request,response);
		   }else{
			    
				session.setAttribute("theName", name);
				session.setAttribute("theEmail", email);
				
				//response.sendRedirect("/WEB-INF/view/index2.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/index2.jsp");
				rd.forward(request,response);
			}
		
		%>
	
	</body>
</html>