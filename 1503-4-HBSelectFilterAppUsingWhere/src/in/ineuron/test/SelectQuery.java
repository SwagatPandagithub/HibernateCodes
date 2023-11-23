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

public class SelectQuery {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			if (session!=null) {				
				Query<BankAccount> query = session.createQuery("from in.ineuron.model.BankAccount");
				List<BankAccount> account=query.getResultList();
				account.forEach(System.out::println);				
			}
		}catch (HibernateException he) {
			he.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
