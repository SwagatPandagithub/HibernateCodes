package in.ineuron.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class InsertRow {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		int rowCount = 0;
		
		
		try {
		
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			
			if (transaction!=null) {
				
				NativeQuery query = session.createSQLQuery("Insert into Product(prodName,prodPrice,prodQty) values('?','?','?') ");
				
				query.setParameter(1, "swagat");
				query.setParameter(2, "35000" );
				query.setParameter(3, 25);
				
				rowCount = query.executeUpdate();
				flag=true;
			}
		
			
				
			}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if (flag) {
					transaction.commit();
					System.out.println("data saved to the database...");
				}else {
					transaction.rollback();
					System.out.println("Something went Wrong transaction.rollback() initiated...");
				}
			
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
		
		
	}

}
