package in.ineuron.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			
			//performing Bulk Operation Using HQL method
			//HQL is performed using MODEL classes
			Query<BankAccount> query=session.createQuery("from in.ineuron.model.BankAccount where Balance>=:amt");
			query.setParameter("amt", 40000.0f);
			
			List<BankAccount> account = query.list();
			account.forEach(System.out::println);
			
			
			
		}catch (HibernateException he) {
			he.printStackTrace();
		}finally {
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
