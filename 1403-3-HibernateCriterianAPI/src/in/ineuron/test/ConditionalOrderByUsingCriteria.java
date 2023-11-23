package in.ineuron.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class ConditionalOrderByUsingCriteria {

	public static void main(String[] args) throws Exception {
		
		Session session= null;
	try {
		session=HibernateUtil.getSession();
		
		Criteria criteria = session.createCriteria(Product.class);//HQL-->from in.ineuron.Product
		
		Criterion cond1 = Restrictions.ge("prodPrice", 100);
		Criterion cond2 = Restrictions.le("prodPrice", 1000);
		
		criteria.add(cond1);
		criteria.add(cond2);//HQL-->from in.ineuron.product where prodprice>100 and prodPrice<1000
		
		
		List product = criteria.list();
		
		product.forEach(System.out::println);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
