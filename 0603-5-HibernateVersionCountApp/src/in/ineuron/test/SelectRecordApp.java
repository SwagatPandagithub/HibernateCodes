package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		MobileCustomer customer = null;
		Transaction transaction = null;
		boolean flag=true;
		
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				
				customer=session.get(MobileCustomer.class, 3);
				System.out.println("Loading the object "+customer);
				
				transaction=session.beginTransaction();
				customer.setCallerTune("isSaalacupNamdey");
				session.update(customer);
				flag=true;			
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Object updated to database after modification :: "+customer);
			}else {
				transaction.rollback();
				System.out.println("Something Went Wrong - Rollback operation initiated. ");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
