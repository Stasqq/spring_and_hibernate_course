package org.czobot.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		System.out.println("into list");
		return "list-customers";
	}
}
