package entity;

public class User {
	private String username;
	private String password;
	private String email;
	private String priviledge;
	
	public User(String username, String password, String email, String priviledge) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.priviledge = priviledge;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void changeUsername(String newUsername) {
		this.username = newUsername;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void changeEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public String getPriviledge() {
		return priviledge;
	}
	
	public void changePriviledge(String newPriviledge) {
		this.priviledge = newPriviledge;
	}
	
	public void sendEmail(String msg) {
		
		//Send msg here////////////////////////////////////////
		
	}
}
