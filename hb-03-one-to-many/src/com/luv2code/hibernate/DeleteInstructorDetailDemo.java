package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		
		int theId=1;
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try{
			
			//begin transaction
			System.out.println("transaction begins");
			session.beginTransaction();
		
			//get Instructor detail
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("Instructor Detail:"+tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor:"+tempInstructorDetail.getInstructor());
			
			//now lets delete the instructor detail
			System.out.println("Deleting tempInstrucorDetail:"+tempInstructorDetail);
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetail);
			
			
			
			//commit the transaction
			System.out.println("Commiting the transaction to database");
			session.getTransaction().commit();
			System.out.println("Done!!!");
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		finally{
			session.close();
			factory.close();
			
		}
								
	}

}