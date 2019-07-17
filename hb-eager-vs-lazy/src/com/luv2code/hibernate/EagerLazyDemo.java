package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try{
			
			//begin transaction
			System.out.println("luv2code: transaction begins");
			session.beginTransaction();
			
			//get instructor from db
			int theId=1;
			Instructor theInstructor=session.get(Instructor.class, theId);
			
			System.out.println("luv2code: Instructor:"+theInstructor);
			
			//calling before session.close()
			System.out.println("Courses:"+theInstructor.getCourses());
			
			//commit the transaction
			System.out.println("luv2code: Commiting the transaction to database");
			session.getTransaction().commit();
			
			//close the session
			session.close();
			System.out.println("\nThe session is now closed!\n");
			
			//get Courses from the Instructor
			//option1: call getter setter before the session closes
			//calling after the session closes
			System.out.println("Courses:"+theInstructor.getCourses());
			
			
		
			System.out.println("luv2code: Done!!!");
		}
		finally{
			session.close();
			factory.close();
		}
								
	}

}