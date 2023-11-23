package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TransferDaoImpl implements ITransferDao {

	@SuppressWarnings("finally")
	@Override
	public String TransferById(Integer id) {

		Session sessionSYSTEM = HibernateUtil.getSession();
		Session sessionHR = HibernateUtil.getSession();
		
		Transaction transaction=null;
		Integer sid=null;
		boolean flag=false;
		
		Product product = sessionSYSTEM.get(Product.class, id);
		
		if(product==null) {
			return "Record not available for copying";
		}else {
			
			try {
			transaction=sessionSYSTEM.beginTransaction();
			sid=(Integer) sessionSYSTEM.save(product);
			flag=true;
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				if(flag) {
					transaction.commit();
					return "Data copitied to the other database with id ::"+sid;
				}else {
					transaction.rollback();
					return "something went wrong";
				}
			}
		}
		
	}

}
