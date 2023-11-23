package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Address;
import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class SelectAppComponentMapping {
	
	public static void main(String[] args) {
		
		
		Session session = null;
		
		
		session= HibernateUtil.getSession();
		try {
			Query<Student> query = session.createQuery("from in.ineuron.model.Student where address.cityName=:city");
			query.setParameter("city", "Bengaluru");
			List<Student> student=	query.list();
			
			student.forEach(System.out::println);
			
			}catch(HibernateException he){
				he.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				
				
				
				HibernateUtil.closeSession(session);
				HibernateUtil.closeSessionFactory();
				
			}
		
	}

}
