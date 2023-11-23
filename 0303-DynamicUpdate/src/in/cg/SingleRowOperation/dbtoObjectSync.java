package in.cg.SingleRowOperation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.Student;

public class dbtoObjectSync {

	public static void main(String[] args) {
		
		Session session= null;
		
		int id=99;
		
		try {//Load the record then update....
		session = HibernateUtil.getSession();
		Student student =session.get(Student.class, id);
		System.out.println("student Record before updation "+student);
		
			if(student!=null) {
				System.in.read();
				session.refresh(student);
				System.out.println("student Record after updation ");
				System.out.println(student);
			}else {
				System.out.println("record not found");
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
