package in.ineuron.test;



import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Insurancepolicies;
import in.ineuron.util.HibernateUtil;

public class Client1 {

	public static void main(String[] args) throws Exception {
		
		Session session=null;
		Transaction transaction = null;		
		boolean flag=false;
		Integer id=1;

		try {
			
			session=HibernateUtil.getSession();
			
			if (session!=null) {
				transaction = session.beginTransaction();
				Insurancepolicies insurance=session.get(Insurancepolicies.class, id,LockMode.UPGRADE_NOWAIT);
				
				System.out.println(insurance);
				Thread.sleep(30000);
				
				insurance.setPolicyTenure(25);
				flag=true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("The data is fetched with the id :: "+id);
			}else {
				transaction.rollback();
				System.out.println("Something went wrong transaction.rollback();  ");
			}
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}