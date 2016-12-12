package footballmania.Model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Team")
public class TeamModel {
	
	@Id
	@Column(name="Team_ID")
	private String teamId;
	@Column(name="Team_Name")
	private String teamName;
	@Transient
	private MultipartFile teamImage;
	
	public TeamModel() {
		//super();
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public MultipartFile getTeamImage() {
		return teamImage;
	}

	public void setTeamImage(MultipartFile teamImage) {
		this.teamImage = teamImage;
	}	
}
