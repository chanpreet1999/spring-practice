package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> query=session.createQuery("from Customer order by lastName",Customer.class);
		
		//execute query and get result list
		List <Customer> customers=query.getResultList(); 
		
		//return the results
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get the current session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//save/update the customer to database
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		//get current session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//get customer from id
		Customer theCustomer=currentSession.get( Customer.class,theId);
		
		
		return theCustomer;
	}

	@Override
	public void delete(int theId) {

		//get the current session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//delete the customer using customer id
		Query query=currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		query.executeUpdate();
	}

}
