package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
		
		//begin transaction
		session.beginTransaction();
		
		int studentId=1;
		System.out.println("Getting Student From id:primary key");
		Student theStudent=session.get(Student.class, studentId);
		System.out.println("\n\nGet completed:"+theStudent);
		
		//update Student
		theStudent.setFirstName("Chanpreet");
		
		//commit the transaction
		session.getTransaction().commit();
		
		//displaying the updated record
		session=factory.getCurrentSession();
		session.beginTransaction();
		theStudent=session.get(Student.class, studentId);
		System.out.println("\n\nAfter updation:"+theStudent);
		session.getTransaction().commit();
		
		//NEW CODE UPDATE ALL RECORDS
		session=factory.getCurrentSession();
		session.beginTransaction();
		
		//update email for all students
		System.out.println("\n\nUpdate email for all students");
		int result=session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
		System.out.println("No. of rows Affected:"+result);
		
		//commit transaction
		session.getTransaction().commit();
		
		}
		finally{
			factory.close();
		}
	} 

}
