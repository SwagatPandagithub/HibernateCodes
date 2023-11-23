package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectRecordDemoCaching {

	public static void main(String[] args) throws Exception {

		Session session = null;
		//Transaction transaction = null;
		boolean flag=true;
		InsurancePolicy policy =null;
		
		try {
			
			session=HibernateUtil.getSession();
			if(session!=null) {
				
				policy=session.get(InsurancePolicy.class, 1L);
				System.out.println(" 1 :: Policy Object"+policy);
				System.out.println("----------------------------");// the data is fetched from the database.
				
				policy = session.get(InsurancePolicy.class, 1L);//The data stored in Session Memory L1 cache
				System.out.println(" 2 :: Policy Object "+policy);
				System.out.println("-------------------------");
				
				
				session.evict(policy);// A particular object is removed from the cache
				
				session.clear();//removes all the object from The L1 Cache
			}
				
					
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				//transaction.commit();
				System.out.println("Object Updated...");
			}else {
				//transaction.rollback();
				System.out.println("Something Went Wrong - Rollback operation initiated. ");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
