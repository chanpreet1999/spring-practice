package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		int instructorId=1;
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
		
			
			Instructor theInstructor=session.get(Instructor.class, instructorId);
			
			//delete the record
			//NOTE:this also deletes the corresponding record in InstructorDetail class
			//
			System.out.println("Found Instructor:"+theInstructor);
			if(theInstructor!=null)
			{
				System.out.println("Deleting the instructor");
				session.delete(theInstructor);
			}
			
			//commit the transaction
			System.out.println("Commiting the transaction to database");
			session.getTransaction().commit();
			System.out.println("Done!!!");
		}
		finally{
			factory.close();
		}
								
	}

}