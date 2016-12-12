package footballmania.DataAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import footballmania.Model.CartDetails;
import footballmania.Model.ProductModel;

@Repository
public class cartImplements implements cartInterface {

@Autowired
SessionFactory sessionFactory;

	@Override
	public List<CartDetails> list(String id) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		String hql = "from CartDetails where userId=" + "'and status=" + "'N";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartDetails> list =(List<CartDetails>)query.list();
		trans.commit();
		session.close();
		return list;
	}

	

	@Override
	public void save(CartDetails cartDetails) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(cartDetails);
		trans.commit();
		session.close();

	}

	@Override
	public void update(String id, int quant) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		CartDetails cart =(CartDetails)session.get(CartDetails.class, id);
		cart.setQuantity(quant);
		session.update(cart);
		trans.commit();
		session.close();

	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long TotalAmount(String id) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		String hql = "from sum(price) CartDetails where userId=" + "'and status=" + "'N";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long)query.uniqueResult();
		trans.commit();
		session.close();
		return sum;
	}



	@Override
	public String displayCart() {
		
		Session session= sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from CartDetails");
		List list = query.list();
		Gson gson = new Gson();
		String cartDisplay = gson.toJson(list);	
		trans.commit();
		session.close();
		return cartDisplay;
		
	}

	@Override
	public CartDetails fetchcart(String id) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		CartDetails cart= (CartDetails) session.get(CartDetails.class, id);
		trans.commit();
		session.close();
		return cart;
}
}
	
