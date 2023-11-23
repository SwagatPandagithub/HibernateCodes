package in.ineuron.test;


import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class ConditionalfewColSelectUsingCriteria {

	public static void main(String[] args) throws Exception {
		
		Session session= null;
	try {
		session=HibernateUtil.getSession();
		
		Criteria criteria = session.createCriteria(Product.class);//HQL-->from in.ineuron.Product
		
		Criterion cond1 = Restrictions.ge("prodPrice", 100);
		Criterion cond2 = Restrictions.le("prodPrice", 1000);
		
		criteria.add(cond1);
		criteria.add(cond2);//HQL-->select from prodname,prodPrice from in.ineuron.product where prodprice>100 and prodPrice<1000 orderby ascending(prodNamme)
		
		//selecting few columns to print projection list are used
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("prodName"));
		projectionList.add(Projections.property("prodPrice"));
		
		criteria.setProjection(projectionList);
		
		Order order = Order.asc("prodName");
		criteria.addOrder(order);
		
		
		//As full entiry class is not asking we have to use partial loading where object type data is fetched
		List<Object[]> product = criteria.list();
		
		product.forEach(row->{
			for(Object obj:row) {
				System.out.print(obj+"  ");
			}
			System.out.println();
		});
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
