package com.luv2code.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
							   .configure("hibernate.cfg.xml")
							   .addAnnotatedClass(Student.class)
							   .buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
		//begin transaction
		session.beginTransaction();
		 
		//query students
		List<Student> theStudents=session.createQuery("from Student").getResultList();
		System.out.println("Displaying all Students");
		displayStudents(theStudents);
		
		//query students with lastName 'Duck'
		theStudents=session.createQuery("from Student where lastName='Duck'").getResultList();
		System.out.println("\n\nStudents with last name Duck");
		displayStudents(theStudents);
		
		//query students with last name duck or first name Chanpreet
		theStudents=session.createQuery("from Student s where s.firstName='Chanpreet' OR s.lastName='Duck'").getResultList();
		System.out.println("\n\nStudents whose First Namer is Chanpreet or last name is Duck");
		displayStudents(theStudents);
		
		//query students where email ends with @gmail.com
		System.out.println("\nStudents having gmail accounts");
		theStudents=session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
		displayStudents(theStudents);
		
		//commit the transaction
		session.getTransaction().commit();
		System.out.println("Done!!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		//display all students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

}