package in.cg.SingleRowOperation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.Student;

public class saveOrUpdate {

	public static void main(String[] args) {
		
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
	
		
		try {//Load the record then update....
		session = HibernateUtil.getSession();
		
		if(session != null) {
			transaction = session.beginTransaction();
		}
		
		if (transaction != null) {
			Student student = new Student();
				student.setsId(99);
				student.setsAge(25);
				student.setsName("Gayle");
				student.setsAddress("West Indies");
						
				session.saveOrUpdate(student);				
				
				flag=true;
				System.out.println(student);
			} else {
				System.out.println("Record Not available for updation.....");
			}
		
		
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if (flag) {
				transaction.commit();
				System.out.println("Record Updated to database....");
			}else {
				transaction.rollback();
				System.out.println("Record not Updated to database....");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
