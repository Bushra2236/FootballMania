package footballmania.DataAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import footballmania.Model.ProductModel;
import footballmania.Model.registerModel;



@Repository
public class registerImplementation implements registerInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void registerUser(registerModel reg) {
		
		
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(reg);
		trans.commit();
		session.close();
		
		}

	@Override
	public String fetchProducts(String id) {
		
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(ProductModel.class);
		criteria.add(Restrictions.eq("prodCat", id));
		List list = criteria.list();
		Gson gson = new Gson();
		String prodList = gson.toJson(list);	
		trans.commit();
		session.close();
		return prodList;
		
	}

	@Override
	public String fetchTeams() {
		
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
	}
