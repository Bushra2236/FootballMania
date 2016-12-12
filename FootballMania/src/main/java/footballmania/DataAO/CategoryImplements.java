package footballmania.DataAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import footballmania.Model.CategoryModel;




@Repository
public class CategoryImplements implements CategoryInterface {

	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	public void addCat(CategoryModel category) {
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
		Query query = session.createQuery("from CategoryModel");
		List list = query.list();
		Gson gson = new Gson();
		String catList = gson.toJson(list);	
		trans.commit();
		session.close();
		return catList;
	}

	@Override
	public CategoryModel fetchCat(String id) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		CategoryModel category = (CategoryModel) session.get(CategoryModel.class, id);
		trans.commit();
		session.close();
		return category;
	}

	@Override
	public void updateCat(CategoryModel category) {
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
		CategoryModel category = (CategoryModel) session.get(CategoryModel.class, id);
		session.delete(category);
		trans.commit();
		session.close();

	}

		@Override
		public String generateCatId() {

		String newCatId="";
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		List<CategoryModel> tempId= session.createQuery("from CategoryModel order by catId desc").list();
		
			if(tempId.size()==0){
				newCatId= "C1";
			}
			else{
				
				CategoryModel category = tempId.get(0);
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
