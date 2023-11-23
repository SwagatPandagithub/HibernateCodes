package in.cg.TestClass;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.cg.model.Student;

public class ProportiesFileApp {

	public static void main(String[] args) {
		
		
		int id=99;
		Session session = null;
		SessionFactory sessionFactory = null;
		
		try {//Load the record then update....
			
			Configuration configuration = new Configuration();
			
			//it searches for hibernate.properties file automatically for the configuration information.
			
			configuration.addAnnotatedClass(Student.class);
			sessionFactory=configuration.buildSessionFactory();
			session=sessionFactory.openSession();
			
			
			Student student =session.get(Student.class, id);
			
			if (student!=null) {
				System.out.println("The Record of the student is :: "+student);
				
			} else {
				System.out.println("The record of the student no found for id ::"+id);
			}
			
			}catch(HibernateException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
			session.close();
			sessionFactory.close();
		}
	}

}
