package footballmania.DataAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import footballmania.Model.ProductModel;




@Repository
public class ProdImplements implements ProdInterface {

	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public void addProd(ProductModel product) {
		
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(product);
		trans.commit();
		session.close();
		

	}

	@Override
	public String displayProduct() {

		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from ProductModel");
		List list = query.list();
		Gson gson = new Gson();
		String prodList = gson.toJson(list);	
		trans.commit();
		session.close();
		return prodList;
	}

	@Override
	public ProductModel fetchProduct(String id) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		ProductModel product= (ProductModel) session.get(ProductModel.class, id);
		trans.commit();
		session.close();
		return product;
	}

	@Override
	public void updateProduct(ProductModel product) 
	{
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(product);		
		trans.commit();
		session.close();
	}

	@Override
	public void deleteProduct(String id) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		ProductModel product= (ProductModel) session.get(ProductModel.class, id);
		session.delete(product);
		trans.commit();
		session.close();

	}

	@Override
	public String displayCategory() {
		
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from CategoryModel");
		List list = query.list();
		Gson gson = new Gson();
		String categoryList = gson.toJson(list);	
		trans.commit();
		session.close();
		return categoryList;
	}

	@Override
	public String displaySupplier() {
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from SupplierModel");
		List list = query.list();
		Gson gson = new Gson();
		String supplierList = gson.toJson(list);	
		trans.commit();
		session.close();
		return supplierList;
	}

	@Override
	public String generateProdId() {
		
		String newProdId="";
		
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		List<ProductModel> tempId= session.createQuery("from ProductModel order by prodId desc").list();
		
			if(tempId.size()==0){
				newProdId= "P1";
			}
			else{
				
				ProductModel product = tempId.get(0);
				String storeId = product.getProdId();
				String firstChar = storeId.substring(0, 1);
				int lastChar = Integer.parseInt(storeId.substring(1,2));
				lastChar++;
				newProdId= firstChar + String.format("%01d",lastChar);
				
			}
			trans.commit();
			session.close();
			return newProdId;
	}
	
	
}
