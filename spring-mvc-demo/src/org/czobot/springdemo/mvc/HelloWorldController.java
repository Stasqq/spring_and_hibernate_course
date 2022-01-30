package org.czobot.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read form data
	// add data to the model

	@RequestMapping("/processFormNew")
	public String addToModel(HttpServletRequest request, Model model) {
		
		// read request parameter from the HTML form
		String name = request.getParameter("studentName");
		
		// convert the data to all caps
		name = name.toUpperCase();
		
		// create the message
		String result = "Hello! " + name;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
