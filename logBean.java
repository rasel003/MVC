package helper;
 
public class logBean{

	private String username;
	private String password;
	private static int visitNumber=0;
	
	public void setVisitNumber(int num){
		this.visitNumber = num;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setUsername(String username){
		this.username = username;
	}
	
	public int getVisitNumber(){
		return visitNumber;
	}
	public String getPassword(){
		return password;
	}
	public String getUsername(){
		return username;
	}
}