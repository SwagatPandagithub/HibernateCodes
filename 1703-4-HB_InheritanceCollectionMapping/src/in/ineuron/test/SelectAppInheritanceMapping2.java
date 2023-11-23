package in.ineuron.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Employee;
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
			
			Query<Employee> employeeQuery = session.createQuery("from in.ineuron.model.Employee");
			List<Employee> employee = employeeQuery.getResultList();
			employee.forEach(System.out::println);
			
		
			
			
		
		
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
