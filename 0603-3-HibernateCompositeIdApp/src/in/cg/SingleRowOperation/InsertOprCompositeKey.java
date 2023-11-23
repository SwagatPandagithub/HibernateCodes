package in.cg.SingleRowOperation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.ProgrammerProjectId;
import in.cg.model.ProgrammerProjectInfo;

public class InsertOprCompositeKey {

	public static void main(String[] args) {
		
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
		
		ProgrammerProjectId pk = null;
		
		
		try {
		session = HibernateUtil.getSession();
		
		if(session != null) {
			transaction = session.beginTransaction();
		}
		
		if (transaction != null) {
			
			/*
			 CREATE
			 * 
			ProgrammerProjectId projId=	new ProgrammerProjectId();
				projId.setpId(100);
				projId.setProjId(501);
			
			ProgrammerProjectInfo projInfo = new ProgrammerProjectInfo();
				projInfo.setId(projId);
				projInfo.setpName("Sachin");
				projInfo.setDeptNo(10);
				projInfo.setProjName("IPL");
			*/
				
				//Update DDL Query
			ProgrammerProjectId projId=	new ProgrammerProjectId();
				projId.setpId(101);
				projId.setProjId(503);
			
			ProgrammerProjectInfo projInfo = new ProgrammerProjectInfo();
				projInfo.setId(projId);
				projInfo.setpName("virat");
				projInfo.setDeptNo(10);
				projInfo.setProjName("ipl");
			
			pk=(ProgrammerProjectId) session.save(projInfo);
			
			flag=true;
			
		}
		
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if (flag) {
				transaction.commit();
				System.out.println("Record Updated to database..with id..:: "+pk);
			}else {
				transaction.rollback();
				System.out.println("Record not Updated to database....");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
