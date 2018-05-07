package controller;
// Import required java libraries
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class successpage implements InterfaceController{
 
  private String message;
  RequestDispatcher rd=null;

  public void process(HttpServletRequest request,HttpServletResponse response,String view) throws IOException,ServletException{

		/* rd = request.getRequestDispatcher(view);
		rd.forward(request,response);  */
		
		response.sendRedirect(view); 
		
	}
  
  
}