package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Address;
import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class InsertAppComponentMapping {
	
	public static void main(String[] args) {
		
		
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		Integer id= null;
		
		session= HibernateUtil.getSession();
		try {
			
			if (session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null) {
				
				Address address = new Address();
				address.setCityName("Mumbai");
				address.setStateName("Maharashtra");
				address.setCountryName("India");
				
				
				Student student = new Student();
				student.setStudName("Sachin");
				student.setStudAge("43");
				
				student.setAddress(address);
				
				id = (Integer)session.save(student);
				
				flag=true;
				
				}
			}catch(HibernateException he){
				he.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				
				if (flag) {
					transaction.commit();
					System.out.println("The objects are added to the database...");
				}else {
					transaction.rollback();
					System.out.println("Something Went Wrong , transaction.rollback() initiated ");
				}
				
				HibernateUtil.closeSession(session);
				HibernateUtil.closeSessionFactory();
				
			}
		
	}

}
