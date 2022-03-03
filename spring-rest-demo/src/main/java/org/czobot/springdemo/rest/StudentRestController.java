package org.czobot.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.czobot.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>() {
			{
				add(new Student("Poornima", "Patel"));
				add(new Student("Mario", "Rossi"));
				add(new Student("Mary", "Smith"));
			}
		};
	}
	
	// define endpoint for "/students" - return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return students;
	}
	
	// define endpoint for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		return students.get(studentId);
	}
}
