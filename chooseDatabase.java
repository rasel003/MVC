package model;

public class chooseDatabase{
	
	public Database getDb(String dbname){
		if(dbname.equals("mysql")){
			return new mysqlAuthenticator();
		}
		else{
			System.out.println("Database Name is Wrong");
			return null;
		}
	}
}