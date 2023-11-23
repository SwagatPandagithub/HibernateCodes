package in.ineuron.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Insurancepolicies;
import in.ineuron.util.HibernateUtil;

public class InsertData {

	public static void main(String[] args) throws Exception {
		
		Session session=null;
		Transaction transaction = null;
		
		boolean flag=false;
		Integer id=null;

		try {
			
			session=HibernateUtil.getSession();
			
			if (session!=null) {
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				
				Insurancepolicies insurance = new Insurancepolicies();
				
				insurance.setPolicyName("Aditya Birla");
				insurance.setPolicyTenure(10);
				
				id = (Integer) session.save(insurance);
				flag=true;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("The data is Stored in the database Successfully with id ::"+id);
			}else {
				transaction.rollback();
				System.out.println("Something Went Wrong");
				System.out.println("Transaction.rollback() initiated");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
