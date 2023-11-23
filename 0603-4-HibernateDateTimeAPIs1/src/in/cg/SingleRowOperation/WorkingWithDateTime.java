package in.cg.SingleRowOperation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.cg.Util.HibernateUtil;
import in.cg.model.PersonInfo;

public class WorkingWithDateTime {

	public static void main(String[] args) {
		
		Session session= null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id=0;
		
		
		try {
		session = HibernateUtil.getSession();
		
		if(session != null) {
			transaction = session.beginTransaction();
		}
		
		if (transaction != null) {
			
			//create a object of the bean class and setter inject the values
			PersonInfo personInfo = new PersonInfo();
			personInfo.setpName("Swagat Sekhar Panda");
			personInfo.setDoj(LocalDate.of(2021, 06, 03));
			personInfo.setDob(LocalDateTime.of(1996, 05, 10, 8, 50));
			personInfo.setDom(LocalTime.of(10, 23));
			
			id=(Integer) session.save(personInfo);
			
			flag=true;
			
		}
		
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if (flag) {
				transaction.commit();
				System.out.println("Record Updated to database..with id..:: "+id);
			}else {
				transaction.rollback();
				System.out.println("Record not Updated to database....");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
