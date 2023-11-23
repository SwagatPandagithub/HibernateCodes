package in.ineuron.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class OneColumnRetrival {

	public static void main(String[] args) throws Exception {
		
		Session session=null;
		
	

		try {
			
			session=HibernateUtil.getSession();
			
			//in which object you keep the hql--->query object
			//Prepare a "Query Object" to Hold HQL
			Query<String> query = session.createQuery("select prodPrice FROM in.ineuron.model.Product WHERE prodName IN(:key1,:key2)");
			
			query.setParameter("key1", "Britannia");
			query.setParameter("key2", "oats");
						
			//Now Execute the query
			List<String> products = query.list();
		
			System.out.println("Product Price");
			
			//Process the list Object
			products.forEach(System.out::println);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
