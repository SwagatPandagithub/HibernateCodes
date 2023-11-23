package in.ineuron.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayments;
import in.ineuron.util.HibernateUtil;

public class InsertAppInheritanceMapping {

	public static void main(String[] args) {
		
		Session session = null;
		
		Transaction transaction = null;
		Integer id= null;
		Integer id1= null;
		boolean flag=false;
		
		session = HibernateUtil.getSession();
		
		try {
			if (session!=null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction!=null) {
				CardPayment card = new CardPayment();
				card.setpId(12345);
				card.setAmount(20000);
				
				card.setCardNo(9778188855L);
				card.setCardType("Debit");
				card.setPaymentGateway("Rupay");
				
				id = (Integer)session.save(card);
				
					
				
				
				
				ChequePayments cheque = new ChequePayments();
				cheque.setpId(12346);
				cheque.setAmount(30000);
				
				cheque.setChequeNo("ICICI1234");
				cheque.setChequeType("DD cheque");
				cheque.setExpiryDate(LocalDate.of(2028, 12, 31));
				
				id1=(Integer)session.save(cheque);
				
				flag=true;
				
			}
		
		
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("The data added to the database...");
			}else {
				transaction.rollback();
					System.out.println("Transaction rollback initiated.... ");
					System.out.println("Something Went Wrong....... ");
				
			}
		}
		
	}
	
}
