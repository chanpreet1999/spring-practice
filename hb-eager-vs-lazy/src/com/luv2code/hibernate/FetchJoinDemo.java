package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try{
			
			//begin transaction
			System.out.println("luv2code: transaction begins");
			session.beginTransaction();
			
			//get instructor from db
			int theId=1;
			
			//option2:hibernate query with hql
			Query<Instructor> query=session.createQuery("select i from Instructor i "+
														"JOIN FETCH i.courses "+
														"where i.id=:theInstructorId"
														,Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor
			Instructor theInstructor=query.getSingleResult();
		
			//print the instructor
			System.out.println("luv2code: Instructor:"+theInstructor);
			
			//commit the transaction
			System.out.println("luv2code: Commiting the transaction to database");
			session.getTransaction().commit();
			
			//close the session
			session.close();
			System.out.println("\nThe session is now closed!\n");
			
			//get courses from instructor
			System.out.println("luv2code: Courses: "+theInstructor.getCourses());
			
		
			System.out.println("luv2code: Done!!!");
		}
		finally{
			session.close();
			factory.close();
		}
								
	}

}