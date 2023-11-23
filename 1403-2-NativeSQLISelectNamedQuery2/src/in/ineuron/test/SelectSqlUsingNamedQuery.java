package in.ineuron.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectSqlUsingNamedQuery {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		
		try {
		
			session=HibernateUtil.getSession();
		
			NativeQuery<Object[]> nativeQuery  = session.getNamedNativeQuery("SQL_SELECT_QUERY");
			
				nativeQuery.setParameter(1,10);
				
				List<Object[]> products = nativeQuery.getResultList();
				
				products.forEach(row->{
					for (Object obj : row) {
						System.out.print(obj+"   ");
					}
					System.out.println();
				});
				

			}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
