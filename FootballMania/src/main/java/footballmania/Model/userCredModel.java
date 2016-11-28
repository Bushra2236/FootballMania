package footballmania.Model;

import javax.persistence.*;

@Entity
@Table(name="User_Credentials")
public class userCredModel {

	@Id
	private String userId;
	private String userPassword;
	private String userRole;
	private Boolean status;
	
	
	public userCredModel() {
	//	super();
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
