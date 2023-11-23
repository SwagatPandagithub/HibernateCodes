package in.cg.main;

import java.io.IOException;
import java.lang.module.Configuration;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import in.cg.model.Student;

public class MainClass1 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SystemException 
	 * @throws HeuristicRollbackException 
	 * @throws HeuristicMixedException 
	 * @throws RollbackException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws IOException, SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {

		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		org.hibernate.Transaction transaction = session.beginTransaction();
		
		Student student=new Student();
		student.setsId(1);
		student.setsName("Swagat");
		student.setsAge(10);
		student.setsAddress("Pune Warriors");
				
		session.save(student);
		
		System.in.read();
		
		transaction.commit();
	}

}
