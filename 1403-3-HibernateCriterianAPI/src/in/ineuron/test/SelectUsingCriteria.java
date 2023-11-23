package in.ineuron.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectUsingCriteria {

	public static void main(String[] args) throws Exception {
		
		Session session= null;
	try {
		session=HibernateUtil.getSession();
		
		Criteria criteria = session.createCriteria(Product.class);
		
		List product = criteria.list();
		
		product.forEach(System.out::println);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
