package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class DeleteCoursesAndReviewsDemo {

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
			
			//get course from id
			int theId=10;
			Course tempCourse=session.get(Course.class,theId);
			
			//print the course
			System.out.println("Course: "+tempCourse);
			
			//print the reviews
			System.out.println("Reviews: "+tempCourse.getReviews());
			
			//deleting the course
			//this will automatically delete the reviews for that course
			System.out.println("deleting this course!!!");
			session.delete(tempCourse);
			
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