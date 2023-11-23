package in.ineuron.test;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class OneFullRowRetreivalUniqueResultOptional {

	public static void main(String[] args) throws Exception {
		
		Session session=null;
		Scanner scan=new Scanner(System.in);
		

		try {
			
			session=HibernateUtil.getSession();
			
			//in which object you keep the hql--->query object
			//Prepare a "Query Object" to Hold HQL
			Query<Product> query = session.createQuery("FROM in.ineuron.model.Product WHERE prodId IN(:prodIdKey)");
			
			System.out.println("Enter the Id of the product to be fetched");
			int id=scan.nextInt();
			
			query.setParameter("prodIdKey", id);
						
			//Now Execute the query			
			Product product = query.uniqueResult();
			
			//handleing code if product is not available in the database
			if(product!=null) {
				System.out.println(product);
			}else {
				System.out.println("Product is not available with the id :: "+id);
			}
		
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
