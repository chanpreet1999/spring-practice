package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try{
			//begin transaction
			System.out.println("transaction begins");
			session.beginTransaction();
			
			//create a new course
			Course tempCourse=new Course("Pacman - How To Score a Hundred Million Points");
			
			//add some reviews
			tempCourse.add(new Review("Great Course Mann!!"));
			tempCourse.add(new Review("Cool Course a Job Well Done"));
			tempCourse.add(new Review("What a dumb course you are an idiot"));
			
			//save the course and leverage the cascade all :-)
			session.save(tempCourse);
			
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