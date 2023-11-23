package in.ineuron.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class DeleteRow {

	public static void main(String[] args) throws Exception {
		
		Session session=null;
		boolean flag=false;
		Transaction transaction=null;
		Integer rowsAffected = null;
		
	

		try {
			
			session=HibernateUtil.getSession();
			
			transaction=session.beginTransaction();
			if(transaction!=null) {
			
			//Prepare a "Query Object" to Hold HQL
			Query query = session.createQuery("DELETE FROM in.ineuron.model.Product  WHERE prodId like :prodId");
			
			query.setParameter("prodId", 5);
						
			
			//Execute the Query	According to the return type of execute Update
			rowsAffected = query.executeUpdate();
		
			
			flag=true;
			}
			
		}catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("The data is successfully updated");
				System.out.println("The number of rows affected is :: "+rowsAffected);
			}else {
				System.out.println("something went wrong");
				System.out.println("Transaction.rollback() initiated");
			}
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
