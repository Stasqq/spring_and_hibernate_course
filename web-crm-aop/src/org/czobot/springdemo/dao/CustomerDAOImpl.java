package org.czobot.springdemo.dao;

import java.util.List;

import org.czobot.springdemo.entity.Customer;
import org.czobot.springdemo.util.SortUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int sortField) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// determine sort field
		String fieldName = null;
		
		switch (sortField) {
			case SortUtils.FIRST_NAME: 
				fieldName = "firstName";
				break;
			case SortUtils.LAST_NAME:
				fieldName = "lastName";
				break;
			case SortUtils.EMAIL:
				fieldName = "email";
				break;
			default:
				// if nothing matches the default to sort by lastName
				fieldName = "lastName";
		}
		
		// create a query  
		String queryString = "from Customer order by " + fieldName;
		Query<Customer> query = 
				currentSession.createQuery(queryString, Customer.class);
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the customer to the db
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrive/read from database using primary key
		Customer customer = currentSession.get(Customer.class, customerId);
	
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", customerId);
		
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String searchName) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = null;
        
        // only search by name if theSearchName is not empty
        if (searchName != null && searchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            query =currentSession.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            query =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = query.getResultList();
                
        // return the results        
        return customers;
	}

}
