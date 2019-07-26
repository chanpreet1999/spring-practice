package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			
			//create a new course
			Course tempCourse=new Course("Pacman - How To Score a Hundred Million Points");
			
			//save the course
			session.save(tempCourse);
			System.out.println("Saved the course:"+tempCourse);
			
			//create the students
			Student student1=new Student("Jon","Doe","Jon@luv2code.com");
			Student student2=new Student("Mary","Public","mary@luv2code.com");
			
			//add Students to course
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			//save the students
			System.out.println("\nSaving the Students...");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved Students:"+tempCourse.getStudents());
			
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