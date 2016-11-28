package footballmania.DataAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;

import footballmania.Model.addSupplierModel;


@Repository
public class addSupplierImplements implements addSupplierInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addSupplier(addSupplierModel supplier) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(supplier);
		trans.commit();
		session.close();
		
	}

	@Override
	public String displaySupplier() {

		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from addSupplierModel");
		List list = query.list();
		Gson gson = new Gson();
		String suppList = gson.toJson(list);	
		trans.commit();
		session.close();
		return suppList;
	}

	@Override
	public addSupplierModel fetchSupplier(String id) {

		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		addSupplierModel supplier = (addSupplierModel) session.get(addSupplierModel.class, id);
		trans.commit();
		session.close();
		return supplier;
	}

	@Override
	public void updateSupplier(addSupplierModel supplier) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(supplier);
		trans.commit();
		session.close();

	}

	@Override
	public void deleteSupplier(String id) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		addSupplierModel supplier= (addSupplierModel) session.get(addSupplierModel.class, id);
		session.delete(supplier);
		trans.commit();
		session.close();

	}

	@Override
	public String generateSuppId() {

		String newSuppId="";
		
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		List<addSupplierModel> tempId= session.createQuery("from addSupplierModel order by supplierId desc").list();
		
			if(tempId.size()==0){
				newSuppId= "S1";
			}
			else{
				
				addSupplierModel supplier = tempId.get(0);
				String storeId = supplier.getSupplierId();
				String firstChar = storeId.substring(0, 1);
				int lastChar = Integer.parseInt(storeId.substring(1,2));
				lastChar++;
				newSuppId= firstChar + String.format("%01d",lastChar);
			}
			trans.commit();
			session.close();
			return newSuppId;
	}

}
