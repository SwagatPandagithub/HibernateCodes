package in.cg.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.cg.model.PersonInfo;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory= null;
	private static Session session= null;
	
	private HibernateUtil() {
	}
	
	static {
		sessionFactory = new Configuration().configure()
				.addAnnotatedClass(PersonInfo.class)
				.buildSessionFactory();
	}
	
	public static Session getSession() {
		
		if (session==null) {
			session=sessionFactory.openSession();
		}
		return session;
		
	}
	
	public static void closeSession(Session session) {
		session.close();
	}
	
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}

