package org.czobot.springdemo.dao;

import java.util.List;

import org.czobot.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers(int sortFields);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);

	public List<Customer> searchCustomers(String searchName);
	
}
