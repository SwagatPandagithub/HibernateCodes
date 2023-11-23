package in.cg.SingleRowOperation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.Student;

public class HibernateGETdata {

	public static void main(String[] args) {
		
		Session session= null;
		int id=10;
		
		try {
		session = HibernateUtil.getSession();
		
		if(session != null) {
			Student student = session.get(Student.class, id);
			if(student!=null) {
				System.out.println(student);
			}else {
				System.out.println("Record Not Found in Database");
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
