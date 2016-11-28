package footballmania.DataAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;

import footballmania.Model.addTeamModel;

@Repository
public class addTeamImplements implements addTeamInterface {
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addTeam(addTeamModel team) {
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
		Query query = session.createQuery("from addTeamModel");
		List list = query.list();
		Gson gson = new Gson();
		String teamList = gson.toJson(list);
				
		trans.commit();
		session.close();
		return teamList;
	}
	
	@Override
	public addTeamModel fetchTeam(String id){
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		addTeamModel team = (addTeamModel) session.get(addTeamModel.class, id);
		trans.commit();
		session.close();
		return team;
	}


	@Override
	public void updateTeam(addTeamModel team) {
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
		addTeamModel team = (addTeamModel) session.get(addTeamModel.class, id);
		session.delete(team);
		trans.commit();
		session.close();
	}

	@Override
	public String generateTeamId() {
		
		String newTeamId="";
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		List<addTeamModel> tempId= session.createQuery("from addTeamModel order by teamId desc").list();
		
		if(tempId.size()==0){
			
			newTeamId="T1";
		}
		
		else{
			
			addTeamModel team = tempId.get(0);
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
