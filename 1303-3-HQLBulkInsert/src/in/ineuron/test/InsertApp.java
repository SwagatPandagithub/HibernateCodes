package in.ineuron.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.dao.IProductDao;
import in.ineuron.dao.ProductDaoImpl;
import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) throws Exception {
		
		IProductDao daoImpl=new ProductDaoImpl();
		String result = daoImpl.TransferProducts(15);
		System.out.println(result);
	}

}
