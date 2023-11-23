package in.ineuron.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayments;
import in.ineuron.model.Payments;
import in.ineuron.util.HibernateUtil;

public class SelectAppInheritanceMapping2 {

	public static void main(String[] args) {
		
		Session session = null;
		
		
		session = HibernateUtil.getSession();
		
		try {
			//As there is no payment table required Table per concrete class, no table for absytract class
			
			/*
			 * Query<Payments> query =
			 * session.createQuery("from in.ineuron.model.Payments"); List<Payments>
			 * payments = query.getResultList(); payments.forEach(System.out::println);
			 * 
			 * System.out.println();
			 */
			
			Query<CardPayment> cardpay = session.createQuery("from in.ineuron.model.CardPayment");
			List<CardPayment> card = cardpay.getResultList();
			card.forEach(System.out::println);
			
			System.out.println();
			
			Query<CardPayment> chequepay = session.createQuery("from in.ineuron.model.ChequePayments");
			List<CardPayment> cheque = chequepay.getResultList();
			cheque.forEach(System.out::println);
		
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
	
}
