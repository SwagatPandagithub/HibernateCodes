package in.ineuron.test;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import com.sun.xml.bind.api.impl.NameConverter.Standard;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectColumnUsingScalarQueries {

	public static void main(String[] args) throws Exception {
		
		Session session = null;
		
		
		try {
		
			session=HibernateUtil.getSession();
		
			@SuppressWarnings("unchecked")
			NativeQuery<Object[]> nativeQuery=session
					.createSQLQuery("SELECT prodName,prodPrice FROM Product where prodQty>=? and prodQty<=?");
			
			nativeQuery.setParameter(1, 10);
			nativeQuery.setParameter(2, 20);
			
			
			//Binding the parameters of the output parameters
			nativeQuery.addScalar("prodName",StandardBasicTypes.STRING);
			nativeQuery.addScalar("prodPrice",StandardBasicTypes.INTEGER);
			
			//Executing to get the result
			List<Object[]> product=nativeQuery.getResultList();
			
			//Processing the result
				product.forEach(row->{
					for(Object obj:row) {
						System.out.println(obj+"\t");
					}
					System.out.println("----");
				});
				
			}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}		
	}
}
