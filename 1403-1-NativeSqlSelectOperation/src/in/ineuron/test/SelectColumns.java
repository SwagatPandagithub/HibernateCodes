package in.ineuron.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectColumns {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		
		
		try {
		
			session=HibernateUtil.getSession();
		
			@SuppressWarnings("unchecked")
			NativeQuery<Object[]> nativeQuery=session
					.createSQLQuery("SELECT prodName FROM Product where prodQty>=? and prodQty<=?");
			
			nativeQuery.setParameter(1, 10);
			nativeQuery.setParameter(2, 20);
			
			
			List<Object[]> product=nativeQuery.getResultList();
			
				product.forEach(row->{
					for(Object obj:row) {
						System.out.println(obj+"\t");
					}
					System.out.println("----");
				});
				
			}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}		
	}
}
