package in.cg.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.Student;

public class HibernateClass2 {

	public static void main(String[] args) {
		
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
		session = HibernateUtil.getSession();
		
		if(session != null) {
			transaction = session.beginTransaction();
		}
		
		if (transaction != null) {
			Student student = new Student();
			student.setsId(18);
			student.setsName("Virat");
			student.setsAge(40);
			student.setsAddress("Royal Banglore");
			
			session.save(student);
			flag=true;
		}
		
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if (flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
