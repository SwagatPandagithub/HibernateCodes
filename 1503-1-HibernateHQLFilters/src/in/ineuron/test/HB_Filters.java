package in.ineuron.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Filter;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class HB_Filters {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		boolean flag=false;
		
		try {
			session=HibernateUtil.getSession();
			
			
			
			org.hibernate.Filter filter =session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
			filter.setParameter("accType1", "Blocked");
			filter.setParameter("accType2", "Active");
			
			//performing Bulk Operation Using HQL method
			//HQL is performed using MODEL classes
			Query<BankAccount> query=session.createQuery("from in.ineuron.model.BankAccount where Balance>=:amt");
			query.setParameter("amt", 40000.0f);
			
			List<BankAccount> account = query.list();
			account.forEach(System.out::println);
			
			System.out.println();
			
			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			
			Query<BankAccount> query1=session.createQuery("from in.ineuron.model.BankAccount where Balance>=:amt");
			query1.setParameter("amt", 40000.0f);
			
			List<BankAccount> account1 = query1.list();
			account1.forEach(System.out::println);
			
		}catch (HibernateException he) {
			he.printStackTrace();
		}finally {
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
