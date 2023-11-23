package in.ineuron.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Filter;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
			
			Criteria criteria1 = session.createCriteria(BankAccount.class);
			Criterion condition1 = Restrictions.ge("balance",45000.0f);
			criteria1.add(condition1);
			
			//Executing and Processing the query
			List<BankAccount> account = criteria1.list();
			account.forEach(System.out::println);
			
			System.out.println();
			
			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			
			Criteria criteria2 = session.createCriteria(BankAccount.class);
			Criterion condition2 = 	Restrictions.ge("balance", 45000.0f);
			criteria2.add(condition2);
			
			List<BankAccount> account2 = criteria2.list();
			account2.forEach(System.out::println);
			
			
		}catch (HibernateException he) {
			he.printStackTrace();
		}finally {
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
