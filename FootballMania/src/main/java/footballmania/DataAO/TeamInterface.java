package footballmania.DataAO;

import footballmania.Model.TeamModel;

public interface TeamInterface {

	void addTeam(TeamModel team);
	String displayTeam();
	TeamModel fetchTeam(String id);
	void updateTeam(TeamModel team);
	void deleteTeam(String id);
	String generateTeamId();
}
