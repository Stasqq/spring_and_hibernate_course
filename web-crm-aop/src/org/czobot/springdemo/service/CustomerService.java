package org.czobot.springdemo.service;

import java.util.List;

import org.czobot.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(int sortField);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);

	public List<Customer> searchCustomers(String searchName);
	
}
