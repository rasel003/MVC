package controller;
 
import java.io.IOException;
import java.util.Scanner;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
import model.chooseDatabase;
import model.Database;
import helper.User;
  
public class loginController implements InterfaceController{

	public void process(HttpServletRequest request,HttpServletResponse response,String view) throws IOException,ServletException{

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		
		if( username==null || password==null || username.length()<3 || password.length()<3 ){
			rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			rd.forward(request, response);  
		}else{
			
			String fwd = "";
			
 
			chooseDatabase selectDb = new chooseDatabase();
			Database db = selectDb.getDb("mysql");
			String result = db.loginAuthenticate(username, password);
			
			/* Scanner sc=new Scanner(System.in); 
			int rollno=sc.nextInt();   */
			
			if (result.equals("success")) {
				fwd ="/WEB-INF/view/success.jsp";
				session.setAttribute( "loggedUser", username );
				session.setAttribute( "loginOrNot", "yes" );
				System.out.println("Logged In success");
			} else {
				fwd ="/WEB-INF/view/login.jsp";
				session.setAttribute( "loggedUser", null);
				session.setAttribute( "loginOrNot", null );
				System.out.println("Log In failed");
			}
			
			rd = request.getRequestDispatcher(fwd);
			rd.forward(request, response);  
			//response.sendRedirect(fwd);
			
		}
		
	}
 
}