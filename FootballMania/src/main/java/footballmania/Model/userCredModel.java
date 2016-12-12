package footballmania.Model;

import javax.persistence.*;

@Entity
@Table(name="User_Credentials")
public class userCredModel {

	@Id
	private String userName;
	private String password;
	private String role;
	private Boolean enabled;
	
	
	public userCredModel() {
	//	super();
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	
	
}
