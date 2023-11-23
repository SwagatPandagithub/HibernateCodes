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
		
		try {
			
			session=HibernateUtil.getSession();
			if(session!=null) {
				
				InsurancePolicy policy1=session.get(InsurancePolicy.class, 1L);
				System.out.println(" 1 :: Policy Object"+policy1);
				System.out.println("----------------------------");// Gets the data from "DB" and puts it in L1 and L2 cache
				
				InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1L);//gets the data from L1 cache
				System.out.println(" 2 :: Policy Object "+policy2);
				System.out.println("-------------------------");
				
				
				session.evict(policy1);// A particular object is removed from the L1 cache
				
				
				InsurancePolicy policy3 = session.get(InsurancePolicy.class, 1L);
				System.out.println(" 2 :: Policy Object "+policy3);
				System.out.println("-------------------------");// gets the data from the L2 Cache and again puts in L1 cache
				
				session.clear();//Clears all the data from the sesson object
				
				Thread.sleep(20000);//20 secs ideal time out is given then the object is removed from the cache mem.
				System.out.println();
				
				InsurancePolicy policy4 = session.get(InsurancePolicy.class, 1L);
				System.out.println(" 2 :: Policy Object "+policy4);
				System.out.println("-------------------------");// Gets the data from "DB" and puts it in L1 and L2 cache
				
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
