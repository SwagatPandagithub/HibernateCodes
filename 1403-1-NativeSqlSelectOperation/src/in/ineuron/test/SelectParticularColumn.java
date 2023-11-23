package in.ineuron.test;


import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import com.sun.xml.bind.api.impl.NameConverter.Standard;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectParticularColumn {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		
		
		try {
		
			session=HibernateUtil.getSession();
		
			@SuppressWarnings("unchecked")
			NativeQuery<String> nativeQuery=session
					.createSQLQuery("SELECT prodName FROM Product where prodQty>=? and prodQty<=?");
			
			nativeQuery.setParameter(1, 10);
			nativeQuery.setParameter(2, 20);
			
			
			
			
			//Executing to get the result
			List<String> product=nativeQuery.getResultList();
			
			//Processing the result
				product.forEach(System.out::println);
				
			}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}		
	}
}
