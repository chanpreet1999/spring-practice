package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}
	
	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		customerDao.saveCustomer(theCustomer);
		
	}
	
	@Transactional
	@Override
	public Customer getCustomer(int theId) {
		return customerDao.getCustomer(theId);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		//call customer dao delete
		customerDao.delete(theId);
	}

	@Transactional
	@Override
	public List<Customer> search(String theSearchName) {
		return customerDao.search(theSearchName);
	}

}
