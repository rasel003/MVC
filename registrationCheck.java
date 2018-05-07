package helper;
 
public class registrationCheck{

	private String name;
	private String password;
	private String username;
	private String email;
	
	public void setName(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public String getUsername(){
		return username;
	}
	public String getEmail(){
		return email;
	}
}