package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try{
			//create a student object
			System.out.println("Creating the student object");
			Student tempStudent=new Student("Manandeep", "Singh", "manan@gmail.com");
			
			//begin transaction
			System.out.println("transaction begins");
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student object");
			session.save(tempStudent);
			
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
