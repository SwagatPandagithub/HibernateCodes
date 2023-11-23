package in.ineuron.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectRows {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		
		
		try {
		
			session=HibernateUtil.getSession();
		
			@SuppressWarnings("unchecked")
			NativeQuery<Product> nativeQuery=session
					.createSQLQuery("SELECT * FROM Product where prodQty>=? and prodQty<=?");
			
			nativeQuery.setParameter(1, 10);
			nativeQuery.setParameter(2, 20);
			
			nativeQuery.addEntity(Product.class);
			
			List<Product> product=nativeQuery.getResultList();
			
				product.forEach(System.out::println);
				
			}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
		
		
	}

}
