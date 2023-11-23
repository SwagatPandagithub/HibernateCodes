	package in.ineuron.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class InsertwithTimeStamp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		Long id = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				
				//Create the object of the bean class and inject the data using setters
				BankAccount bankAccount = new BankAccount();
				bankAccount.setAccName("Swagat");
				bankAccount.setAccBalance(50000.00);
				bankAccount.setAccType("savings");
				
				id = (Long)session.save(bankAccount);
				
				
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: "+id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
