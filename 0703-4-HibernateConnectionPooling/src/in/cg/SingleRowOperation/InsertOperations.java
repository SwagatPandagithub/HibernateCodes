package in.cg.SingleRowOperation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.Student;

public class InsertOperations {

	public static void main(String[] args) {
		
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
		Integer Id = null;
		
		try {
		session = HibernateUtil.getSession();
		
		if(session != null) {
			transaction = session.beginTransaction();
		}
		
		if (transaction != null) {
			Student student = new Student();
			
			student.setsName("swagat");
			student.setsAddress("IND");
			student.setsAge(45);
			
			Id = (Integer) session.save(student);
			flag=true;
		}
		
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if (flag) {
				transaction.commit();
				System.out.println("Record Updated to database..with id..:: "+Id);
			}else {
				transaction.rollback();
				System.out.println("Record not Updated to database....");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
