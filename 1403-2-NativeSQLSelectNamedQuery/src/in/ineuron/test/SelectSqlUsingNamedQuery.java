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
		Transaction transaction = null;
		boolean flag= false;
		
		try {
		
			session=HibernateUtil.getSession();
			transaction = session.beginTransaction();
			int rowCount=0;
				
		
			NativeQuery<Object[]> nativeQuery  = session.getNamedNativeQuery("SQL_INSERT_QUERY");
			
				nativeQuery.setParameter(1,"Swagat");
				nativeQuery.setParameter(2,"234567");
				nativeQuery.setParameter(3,234);
				
				//Execute the Query
				rowCount = nativeQuery.executeUpdate();
				flag=true;
				
				

			}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("The data got added to the database...");
			}else {
				transaction.rollback();
				System.out.println("Something went wrong transaction.rollback initiated....");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
