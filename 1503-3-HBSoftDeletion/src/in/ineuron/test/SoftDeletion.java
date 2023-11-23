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

public class SoftDeletion {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		boolean flag=false;
		Transaction transaction= null;
		try {
			session=HibernateUtil.getSession();			
			transaction = session.beginTransaction();
			
			BankAccount account = new BankAccount();
			account.setAccNo(5);
			
			session.delete(account);
			
			flag=true;
		}catch (HibernateException he) {
			he.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object status changed to CLOSED....");
			}else {
				transaction.rollback();
				System.out.println("Something went wrong transaction.rollback initiated...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
