package in.ineuron.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SELECTOperationUsingHQL {

	public static void main(String[] args) throws Exception {
		
		Session session=null;
		
	

		try {
			
			session=HibernateUtil.getSession();
			
			//in which object you keep the hql--->query object
			//Prepare a "Query Object" to Hold HQL
			Query<Product> query = session.createQuery("FROM in.ineuron.model.Product");
			
			//Now Execute the query
			//query object should be executed
			//earlier the result from the executed query in JDBC is holded by resultset object
			//and the resultset object is not transferrable over the network so we used to create a DTO object
			//and also a list where we used to put the dto objects in each cells of the list
			// now all the repeated logics are reduced and done by ORM
					
			List<Product> products = query.list();
		
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
