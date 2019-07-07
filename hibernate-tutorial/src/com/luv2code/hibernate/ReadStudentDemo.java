package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try{
			//create a student object
			System.out.println("Creating the student object");
			Student theStudent=new Student("Daffy", "Duck", "daffy@luv2code.com");
			
			//begin transaction
			System.out.println("transaction begins");
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student object");
			session.save(theStudent);
			
			//commit the transaction
			System.out.println("Commiting the transaction to database");
			session.getTransaction().commit();
				
		
			//MY NEW CODE
			
			//find out student's id: primary key
			System.out.println("Saved Student Generated id:"+theStudent.getId());
			
			//now get a session and begin transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting Student with id:"+theStudent.getId());
			Student myStudent=session.get(Student.class, theStudent.getId());
			System.out.println("Get Complete:"+myStudent);
			session.getTransaction().commit();
			System.out.println("Done!!!");
			}
		finally{
			factory.close();
		}

	}

}
