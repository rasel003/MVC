package model;
 
public interface Database {
	
	public String loginAuthenticate(String username, String password);
	
	public String insertIntoDb(String name, String email, String username, String password);
}