package org.czobot.springdemo.controller;

import java.util.List;

import org.czobot.springdemo.dao.CustomerDAO;
import org.czobot.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		// get customers from the dao
		List<Customer> customers = customerDAO.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
