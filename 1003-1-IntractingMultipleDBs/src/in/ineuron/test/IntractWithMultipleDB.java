package in.ineuron.test;

import in.ineuron.dao.ITransferDao;
import in.ineuron.dao.TransferDaoImpl;
import in.ineuron.util.HibernateUtil;

public class IntractWithMultipleDB {

	public static void main(String[] args) throws Exception {

		
		ITransferDao dao = new TransferDaoImpl();
		System.out.println(dao.TransferById(1));
		
		
		HibernateUtil.closeSessionFactory();
	}

}
