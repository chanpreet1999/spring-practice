package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		//create 3 student objects
		System.out.println("Creating 3 student objects");
		Student tempStudent1=new Student("Chanpreet","Singh","chan@gmail.com");
		Student tempStudent2=new Student("Mananadeep","Singh","manan@ymail.com");
		Student tempStudent3=new Student("Ashdeep","Singh","ashu@hotmail.com");
		try{
		
		//begin transaction
		session.beginTransaction();
		
		//save the 3 objects to sessions
		System.out.println("Saving the three objects to database");
		session.save(tempStudent1);
		session.save(tempStudent2);
		session.save(tempStudent3);
		
		//commit the transaction
		System.out.println("Commiting the transaction");
		session.getTransaction().commit();
		System.out.println("Done!!!");
		
		}
		finally{
			factory.close();
		}
	}

}
