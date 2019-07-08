package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		int studentId=1;
		try{
		/*
			//METHOD 1
			//begin transaction
			System.out.println("transaction begins");
			session.beginTransaction();
			
			Student myStudent=session.get(Student.class, studentId);
			
			//MY DELETE CODE
			//USING session.delete(obj)
			session.delete(myStudent);
			
			//commit the transaction
			System.out.println("Commiting the transaction to database");
			session.getTransaction().commit();
			*/
			
			
			//METHOD 2 
			//USING session.createQuery
			System.out.println("\n\nMETHOD 2");
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			int result=session.createQuery("delete from Student where firstName='Mananadeep'").executeUpdate();
			System.out.println("\n\nNo. of rows affected:"+result);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			}
		finally{
			factory.close();
		}

	}

}
