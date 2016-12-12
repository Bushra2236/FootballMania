package footballmania.DataAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footballmania.Model.OrderDetails;


@Repository

public class orderDetailsImplements implements orderDetailsInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addOrder(OrderDetails order) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(order);
		trans.commit();
		session.close();

	}

}
