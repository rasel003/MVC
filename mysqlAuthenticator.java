package model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysqlAuthenticator implements Database {
 
	public String loginAuthenticate(String username, String password) {
		boolean isValid = false;
		 if(!username.isEmpty() && !password.isEmpty()){
			 
			 try{
				
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/rasel";
				Class.forName(driver);
					
				Connection con= (Connection) DriverManager.getConnection(url,"root","rasel");
				PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * from userinfo");
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					if(username.equals(rs.getString("username").trim()) && password.equals(rs.getString("password").trim()) ) {
						isValid = true;
					}
				}
			 }catch(Exception e){
				System.out.println(e.getMessage());
			 }
		  }  
		  if(isValid){
				return "success";
		  }else {
			 return "failure";
		  }
	}
	public String insertIntoDb(String name, String email, String username, String password) {
		
		if(name ==null || email ==null || username.length()<2 || password.length()<3){
			  return "failure";
		}
		else{
			   try{
			    
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/rasel";
				Class.forName(driver);
					
				Connection con= (Connection) DriverManager.getConnection(url,"root","rasel");
				Statement st=con.createStatement();				
				int i=st.executeUpdate("insert into userinfo (name,email,username,password) values('"+name+"','"+email+"','"+username+"','"+password+"')");
								
				return "success";
			   }
			   catch(Exception e){
					System.out.println(e.getMessage());
					return "failure";
			   }
		}
	}
}