package footballmania.DataAO;

import footballmania.Model.addTeamModel;

public interface addTeamInterface {

	void addTeam(addTeamModel team);
	String displayTeam();
	addTeamModel fetchTeam(String id);
	void updateTeam(addTeamModel team);
	void deleteTeam(String id);
	String generateTeamId();
}
