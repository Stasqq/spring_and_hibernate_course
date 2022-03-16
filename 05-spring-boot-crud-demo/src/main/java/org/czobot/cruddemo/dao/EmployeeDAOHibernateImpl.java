package org.czobot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.czobot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entityManager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		// execute query
		List<Employee> employees = query.getResultList();
		
		// return result
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee employee = currentSession.get(Employee.class, id);
		
		// return the employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {

		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
