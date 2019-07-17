package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try{
			//create instructor object
			Instructor instructor=new  Instructor("Susan","Public","susan@luv2code.com");
			//create instructorDetails object
			InstructorDetail instructorDetail=new InstructorDetail("Video games","www.youtube.com");
			
			
			//begin transaction
			System.out.println("transaction begins");
			session.beginTransaction();
		
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.save(instructor);
		
			//commit the transaction
			System.out.println("Commiting the transaction to database");
			session.getTransaction().commit();
			System.out.println("Done!!!");
		}
		finally{
			session.close();
			factory.close();
		}
								
	}

}