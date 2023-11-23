package in.cg.SingleRowOperation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.Student;

public class Delete {

	public static void main(String[] args) {
		
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
		int id=18;
		
		try {//Load the record then update....
		session = HibernateUtil.getSession();
		
		if(session != null) {
			transaction = session.beginTransaction();
		}
		
		if (transaction != null) {
			Student student= new Student();
				student.setsId(99);// Programmer has to remember the ID of the data in the table or has to remember the table
				
			session.delete(student);	
				
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
