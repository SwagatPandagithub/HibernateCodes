package in.cg.SingleRowOperation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.ProgrammerProjectId;
import in.cg.model.ProgrammerProjectInfo;

public class SelectOprCompositeKey {

	public static void main(String[] args) {
		
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
		
		ProgrammerProjectId pk = null;
		
		
		try {
		session = HibernateUtil.getSession();
		
		if(session != null) {
			
			ProgrammerProjectId id=new ProgrammerProjectId();
			id.setpId(100);
			id.setProjId(502);
			
			ProgrammerProjectInfo object = session.get(ProgrammerProjectInfo.class, id);
			
			if (object!=null) {
				System.out.println("The given record found :: "+object);
			} else {
				System.out.println("Record not found for"+id);
			}
			
		}
		
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
