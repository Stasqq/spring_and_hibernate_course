package org.czobot.springdemo.dao;

import java.util.List;

import org.czobot.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
	
}
