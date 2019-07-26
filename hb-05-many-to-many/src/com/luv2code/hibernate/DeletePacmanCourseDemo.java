package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try{
			//begin transaction
			System.out.println("transaction begins");
			session.beginTransaction();
			
			//get the pacman course
			int courseId=1;
			Course tempCourse=session.get(Course.class, courseId);
			
			//delete the course
			System.out.println("Deleting course:"+tempCourse);
			
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