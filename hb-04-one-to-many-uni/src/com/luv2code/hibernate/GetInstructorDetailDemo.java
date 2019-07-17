package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		
		int theId=2;
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
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("Instructor Detail:"+instructorDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor:"+instructorDetail.getInstructor());
			//commit the transaction
			System.out.println("Commiting the transaction to database");
			session.getTransaction().commit();
			System.out.println("Done!!!");
		}
		catch(Exception exc){
			System.out.println(exc);
		}
		finally{
			session.close();
			factory.close();
			
		}
								
	}

}