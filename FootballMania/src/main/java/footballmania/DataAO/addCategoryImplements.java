package footballmania.DataAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import footballmania.Model.addCategoryModel;




@Repository
public class addCategoryImplements implements addCategoryInterface {

	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	public void addCat(addCategoryModel category) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(category);
		trans.commit();
		session.close();

	}

	@Override
	public String displayCat() {
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from addCategoryModel");
		List list = query.list();
		Gson gson = new Gson();
		String catList = gson.toJson(list);	
		trans.commit();
		session.close();
		return catList;
	}

	@Override
	public addCategoryModel fetchCat(String id) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		addCategoryModel category = (addCategoryModel) session.get(addCategoryModel.class, id);
		trans.commit();
		session.close();
		return category;
	}

	@Override
	public void updateCat(addCategoryModel category) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(category);
		trans.commit();
		session.close();

	}

	@Override
	public void deleteCat(String id) {
		
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		addCategoryModel category = (addCategoryModel) session.get(addCategoryModel.class, id);
		session.delete(category);
		trans.commit();
		session.close();

	}

		@Override
		public String generateCatId() {

		String newCatId="";
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		List<addCategoryModel> tempId= session.createQuery("from addCategoryModel order by catId desc").list();
		
			if(tempId.size()==0){
				newCatId= "C1";
			}
			else{
				
				addCategoryModel category = tempId.get(0);
				String storeId = category.getCatId();
				String firstChar = storeId.substring(0, 1);
				int lastChar = Integer.parseInt(storeId.substring(1,2));
				lastChar++;
				newCatId= firstChar + String.format("%01d", lastChar);
			}
			trans.commit();
			session.close();
			return newCatId;
		}


}
