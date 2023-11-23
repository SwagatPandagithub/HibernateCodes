package in.ineuron.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class StoringLOBs {

	public static void main(String[] args) throws Exception {
		
		Session session=null;
		Transaction transaction = null;
		byte[] photo = null;
		char[] resume=null;
		File f= null;
		boolean flag=false;
		Integer id=null;

		
//Logic to copy the data to Byte array
		try(FileInputStream fis = new FileInputStream("C:\\Users\\SWAGAPAN\\Desktop\\INeuron\\swagatPassport.jpg")) {
			photo = new byte[fis.available()];
			fis.read(photo);
		}
		
		
//Logic to copy the data to Charecter array
		try{
			f= new File("C:\\Users\\SWAGAPAN\\Desktop\\INeuron\\resume.txt");
			
			try(FileReader fr = new FileReader(f)){
				resume=new char[(int) f.length()];
				fr.read(resume);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		try {
			
			session=HibernateUtil.getSession();
			
			if (session!=null) {
				transaction=session.beginTransaction();
			}
			if (transaction!=null) {
				JobSeeker jobseeker = new JobSeeker();
				jobseeker.setName("Swagat Sekhar Panda");
				jobseeker.setAge("26");
				jobseeker.setPhoto(photo);
				jobseeker.setResume(resume);
				
				id=(Integer) session.save(jobseeker);
				
				flag=true;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("The Large Objects are Stored in the database Successfully with id ::"+id);
			}else {
				transaction.rollback();
				System.out.println("Something Went Wrong");
				System.out.println("Transaction.rollback() initiated");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
