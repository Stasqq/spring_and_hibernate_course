package org.czobot.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.czobot.hibernate.demo.entity.Course;
import org.czobot.hibernate.demo.entity.Instructor;
import org.czobot.hibernate.demo.entity.InstructorDetail;
import org.czobot.hibernate.demo.entity.Review;
import org.czobot.hibernate.demo.entity.Student;

public class AddCoursesForStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the student from db
			int studentId = 1;
			Student student = session.get(Student.class, studentId);	
			
			System.out.println("Loaded student: " + student);
			System.out.println("Student courses: " + student.getCourses());
			
			// create more courses
			Course firstCourse = new Course("Rubiks's Cube Course");
			Course secondCourse = new Course("Atari 2600 - Game Development");
			
			// add student to courses
			firstCourse.addStudent(student);
			secondCourse.addStudent(student);
			
			// save the courses
			System.out.println("Saving the courses");
			
			session.save(firstCourse);
			session.save(secondCourse);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			// add clean code
			session.close();
			
			factory.close();
		}
	}

}
