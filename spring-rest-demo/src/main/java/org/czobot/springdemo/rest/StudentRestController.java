package org.czobot.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.czobot.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// define endpoint for "/students" - return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> students = new ArrayList<>() {
			{
				add(new Student("Poornima", "Patel"));
				add(new Student("Mario", "Rossi"));
				add(new Student("Mary", "Smith"));
			}
		};
		
		return students;
	}
}
