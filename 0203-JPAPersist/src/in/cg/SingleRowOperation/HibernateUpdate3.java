package in.cg.SingleRowOperation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.Student;

public class HibernateUpdate3 {

	public static void main(String[] args) {
		
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
		int id=18;
		
		try {//Load the record then update....
		session = HibernateUtil.getSession();
		Student student =session.get(Student.class, id);
		
		if(session != null) {
			transaction = session.beginTransaction();
		}
		
		if (transaction != null) {
			if (student!=null) {
				System.out.println(student);
				System.out.println();
				student.setsAddress("Anuska's Team");
				//WithOut the Update() method we can update the table data in the database
				flag=true;
				System.out.println(student);
			} else {
				System.out.println("Record Not available for updation.....");
			}
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
