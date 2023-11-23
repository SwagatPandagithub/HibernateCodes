package in.ineuron.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class InsertAppInheritanceMapping {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		Integer id=null;
	
		session = HibernateUtil.getSession();
		
		try {
			if (session!=null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction!=null) {
				Employee employee= new Employee();
				
				employee.seteId(10);
				employee.setEmpName("Sachin");
				employee.setEmpAddr("Mumbai Indians");
				
				
				employee.setFriendList(List.of("Saurav","Dravid","Sehwag"));
				employee.setPhones(Set.of(99223344L,8767562L,67654398L));
				employee.setBankAccounts(Map.of("SBI",123456L,"HDFC",456789L,"ICICI",765432L));
				
				
				id= (Integer)session.save(employee);
				
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
