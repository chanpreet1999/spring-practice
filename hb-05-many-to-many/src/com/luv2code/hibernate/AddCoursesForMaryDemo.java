package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
			
			//get student mary from database
			int studentId=2;
			Student tempStudent=session.get(Student.class, studentId);
			System.out.println("\nLoaded Student:"+tempStudent);
			System.out.println("Course:"+tempStudent.getCourses());
			
			//create more courses
			Course tempCourse1=new Course("Rubik's Cube-How to speed cube");
			Course tempCourse2=new Course("Atari 2600-Game Development");
			
			//add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			//save the courses
			System.out.println("\nSaving the Courses....");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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