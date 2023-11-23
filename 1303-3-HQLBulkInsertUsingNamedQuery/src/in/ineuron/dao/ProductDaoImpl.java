package in.ineuron.dao;
import javax.persistence.criteria.CriteriaUpdate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class ProductDaoImpl implements IProductDao {
	


	@Override
	public String TransferProducts(int minQty) {
		
		Session session = null;
		Transaction transaction = null;
		int rowsAffected = 0;
		Query query = null;
		boolean flag=false;
		String msg=null;
		
		try {
		
			session=HibernateUtil.getSession();
		
			transaction = session.beginTransaction();

				query = session.getNamedQuery("HQL_TRANFER_QUERY");
			
				query.setParameter("minQty",minQty);
				rowsAffected = query.executeUpdate();
				flag=true;

			}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if (flag) {
				transaction.commit();
				 msg="The Number of rows Affected :: "+rowsAffected;
			}else {
				transaction.rollback();
				 msg ="Transaction.rollback initiated Something Went Wrong...";
			}
		}
		
		return msg;
	}

}
