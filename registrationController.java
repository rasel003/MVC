package controller;
 
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import model.chooseDatabase;
import model.Database;
  
public class registrationController implements InterfaceController {
 
	public void process(HttpServletRequest request,HttpServletResponse response,String view) throws IOException,ServletException{

		HttpSession session = request.getSession(true);
		
		String name = (String)session.getAttribute("theName");
		String email = (String)session.getAttribute("theEmail");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		String fwd ="";
		System.out.println("In the registration Controller");
		
		if( name==null || email==null ||  name.length()<3 || email.length()<3 ){
			fwd ="/WEB-INF/view/registration.html";
			//response.sendRedirect("registration.html");
		}
		else if( username==null || password==null || username.length()<3 || password.length()<3 ){
			
			fwd ="/WEB-INF/view/index2.jsp";
			//response.sendRedirect("index2.jsp");
		}		
		else{
 
			chooseDatabase selectDb = new chooseDatabase();
			Database db = selectDb.getDb("mysql");
			String result = db.insertIntoDb(name, email, username, password);
			
			if (result.equals("success")) {
				fwd ="/WEB-INF/view/login.jsp";
				//response.sendRedirect("login.jsp");
				System.out.println("Values are registered");
			} else {
				fwd ="/WEB-INF/view/index2.jsp";
				//response.sendRedirect("index2.jsp");
			}
		}
		
		rd = request.getRequestDispatcher(fwd);
		rd.forward(request, response);  
		
		//response.sendRedirect(fwd);
	}
}