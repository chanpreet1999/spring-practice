package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
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
		
			//create instructor object
			Instructor instructor=new  Instructor("Manandeep","Chugh","manan@ymail.com");
			//create instructorDetails object
			InstructorDetail instructorDetail=new InstructorDetail("CFA","www.textiles.com/youtube");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.save(instructor);
			/*	
			//create instructor object
			Instructor instructor=new  Instructor("Chanpreet","Singh","chan@gmail.com");
			
			InstructorDetail instructorDetail=new InstructorDetail("Cricketer","www.luv2code.com/youtube");
			
			instructor.setInstructorDetail(instructorDetail);
			
			//save instructor
			//
			//NOTE:this will ALSO save the details object
			//because of CascadeType.ALL
			//
			System.out.println("Saving the instructor...");
			session.save(instructor);
		*/	
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