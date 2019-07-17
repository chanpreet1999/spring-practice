package com.chanpreet.code;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chanpreet.entity.Employee;

public class Operations {
	
	public static SessionFactory configuration(){
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		return factory;
	}
	
	public static void createEmployee(){
		
		SessionFactory factory=Operations.configuration();
		try{
			Session session=factory.getCurrentSession();
			//begin transaction
			session.beginTransaction();
			
			//create employee object
			Employee theEmployee1=new Employee("Chanpreet", "Singh", "Apple");
			Employee theEmployee2=new Employee("Ashdeep", "Singh", "Google");
			Employee theEmployee3=new Employee("Manandeep", "Chugh", "Microsoft");
		
			
			//save employee
			session.save(theEmployee1);
			session.save(theEmployee2);
			session.save(theEmployee3);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//end
			System.out.println("\n\nDone!!");
		}
		finally{
			factory.close();
		}
	}



	public static void showAllEmployees(){
	SessionFactory factory=Operations.configuration();
	try{
		Session session=factory.getCurrentSession();
		//begin transaction
		session.beginTransaction();
		
		List<Employee> allEmployees=session.createQuery("from Employee").getResultList();
		System.out.println("\nHere is a list of all the employees:\n\n");
		for(Employee theEmployee : allEmployees)
		{
			System.out.println(theEmployee);
		}
		//commit the transaction
		session.getTransaction().commit();
		System.out.println("\n\nDone!!");
	}
	finally{
		factory.close();
	}
  }


public static void findEmployeeById(){
	SessionFactory factory=Operations.configuration();
	int employeeId=1;
	try{
		Session session=factory.getCurrentSession();
		//begin transaction
		session.beginTransaction();
		
		Employee theEmployee=session.get(Employee.class, employeeId);
		System.out.println("The employee is:\n"+theEmployee);
		
		//commit the transaction
		session.getTransaction().commit();
		System.out.println("\n\nDone!!");
	}
	finally{
		factory.close();
	}
  }




public static void updateEmployeeDetails(){
	SessionFactory factory=Operations.configuration();
	int employeeId=2;
	try{
		Session session=factory.getCurrentSession();
		//begin transaction
		session.beginTransaction();
		
		Employee theEmployee=session.get(Employee.class, employeeId);
		theEmployee.setFirstName("Jethalal");
		
		//commit the transaction
		session.getTransaction().commit();
	}
	finally{
		factory.close();
	}
  }




public static void deleteEmployee(){
	SessionFactory factory=Operations.configuration();
	try{
		Session session=factory.getCurrentSession();
		//begin transaction
		session.beginTransaction();
		int result = session.createQuery("delete from Employee e where e.id=3").executeUpdate();
		
		if(result==0){
			System.out.println("\n\nNo record found");
		}
		else{
			System.out.println("Record deleted successfully");
		}
		//commit the transaction
		session.getTransaction().commit();
		System.out.println("\n\nDone!!!");
	}
	finally{
		factory.close();
	}
  }
}