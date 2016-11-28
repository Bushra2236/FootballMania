package footballmania.DataAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import footballmania.Model.userCredModel;

@Repository

public class userCredImplementation implements userCredInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addUserCred(userCredModel ucm) {
	
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(ucm);
		trans.commit();
		session.close();
		
	}

}
