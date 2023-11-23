package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectDataWithTimeStamp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		boolean flag=true;
		long id=6L;
		BankAccount account= null;
		
		try {
			session = HibernateUtil.getSession();
			account = session.get(BankAccount.class, id);
			System.out.println("Before modification ::"+account);
				if (session!=null) {
					transaction=session.beginTransaction();
				}
				
				if (transaction!=null) {				
					if (account!=null) {
						account.setAccBalance(account.getAccBalance()+10000);
						flag=true;
					} else {
						System.out.println("record not available for the given ID ::"+id);
						System.exit(0);
					}
				}
				
					
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Object Updated...");
				System.out.println("Account opening date :: "+account.getOpeningDate());
				System.out.println("Account Data last Updating date :: "+account.getLastUpdated());
			}else {
				transaction.rollback();
				System.out.println("Something Went Wrong - Rollback operation initiated. ");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
