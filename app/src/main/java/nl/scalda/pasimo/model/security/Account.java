package nl.scalda.pasimo.model.security;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	private String userID;
	private String userName;
	private boolean passwordSame = false;
	
	public boolean load(String userName){

		return false;
	}
	
	public void samePassword(String password){
		
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public boolean isPasswordSame() {
		return passwordSame;
	}
	private void setPasswordSame(boolean passwordSame) {
		this.passwordSame = passwordSame;
	}
}
