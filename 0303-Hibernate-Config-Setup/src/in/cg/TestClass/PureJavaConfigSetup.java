package in.cg.TestClass;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.cg.model.Student;

public class PureJavaConfigSetup {

	public static void main(String[] args) {
		
		
		int id=99;
		Session session = null;
		SessionFactory sessionFactory = null;
		
		try {//Load the record then update....
			
			Configuration configuration = new Configuration();
//Instead of the configure() the proporties can be added directly
			
			//Setting the proporties of the configuration object using the pure java code
			configuration.setProperty("hibernate.connection.driver.class", "oracle.jdbc.driver.OracleDriver");
			configuration.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
			configuration.setProperty("hibernate.connection.username", "system");
			configuration.setProperty("hibernate.connection.password", "sekhar");

			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			configuration.setProperty("hibernate.show_sql", "true");
			configuration.setProperty("hibernate.format_sql", "true");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");

			
			
			configuration.addAnnotatedClass(Student.class);
			sessionFactory=configuration.buildSessionFactory();
			session=sessionFactory.openSession();
			
			
			Student student =session.get(Student.class, id);
			
			if (student!=null) {
				System.out.println("The Record of the student is :: "+student);
				
			} else {
				System.out.println("The record of the student no found for id ::"+id);
			}
			
			}catch(HibernateException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
			session.close();
			sessionFactory.close();
		}
	}

}
