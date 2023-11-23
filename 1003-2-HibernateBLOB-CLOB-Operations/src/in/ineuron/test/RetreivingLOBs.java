package in.ineuron.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class RetreivingLOBs {

	public static void main(String[] args) throws Exception {
		
		Session session=null;
		JobSeeker seeker =null;
		Integer id=21;
		
		
		
		try {
			
			session=HibernateUtil.getSession();
			
			if (session!=null) {
				seeker = session.get(JobSeeker.class, id);
			}
			if (session!=null) {
				System.out.println("Id of the seeker is :: "+seeker.getId());
				System.out.println("name of the jobseeker is :: "+seeker.getName());
				System.out.println("Age of the jobseeker is :: "+seeker.getAge());
				
				try(FileOutputStream fos = new FileOutputStream("./store/photo.jpeg");
						FileWriter fw = new FileWriter("./store/resume.jpeg")){
						
					fos.write(seeker.getPhoto());
					fw.write(seeker.getResume());
					System.out.println("photo and resume are successfully retreived..placed in store folder in the project");
				}
				
			}else {
				System.out.println("Data is not available for the id :: "+id);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
