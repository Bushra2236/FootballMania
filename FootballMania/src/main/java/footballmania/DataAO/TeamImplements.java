package footballmania.DataAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;

import footballmania.Model.TeamModel;

@Repository
public class TeamImplements implements TeamInterface {
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addTeam(TeamModel team) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(team);
		trans.commit();
		session.close();
	}
	
	@Override
	public String displayTeam() {
		
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from TeamModel");
		List list = query.list();
		Gson gson = new Gson();
		String teamList = gson.toJson(list);
				
		trans.commit();
		session.close();
		return teamList;
	}
	
	@Override
	public TeamModel fetchTeam(String id){
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		TeamModel team = (TeamModel) session.get(TeamModel.class, id);
		trans.commit();
		session.close();
		return team;
	}


	@Override
	public void updateTeam(TeamModel team) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(team);
		trans.commit();
		session.close();
		
	}

	@Override
	public void deleteTeam(String id) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		TeamModel team = (TeamModel) session.get(TeamModel.class, id);
		session.delete(team);
		trans.commit();
		session.close();
	}

	@Override
	public String generateTeamId() {
		
		String newTeamId="";
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		List<TeamModel> tempId= session.createQuery("from TeamModel order by teamId desc").list();
		
		if(tempId.size()==0){
			
			newTeamId="T1";
		}
		
		else{
			
			TeamModel team = tempId.get(0);
			String storeId = team.getTeamId();
			String firstChar = storeId.substring(0, 1);
			int lastChar = Integer.parseInt(storeId.substring(1,2));
			lastChar++;
			newTeamId= firstChar + String.format("%01d", lastChar);
			
		}
		trans.commit();
		session.close();
		return newTeamId;
	}
}
