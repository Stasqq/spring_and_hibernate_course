package org.czobot.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.czobot.hibernate.demo.entity.Course;
import org.czobot.hibernate.demo.entity.Instructor;
import org.czobot.hibernate.demo.entity.InstructorDetail;
import org.czobot.hibernate.demo.entity.Review;
import org.czobot.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			
			// create a course
			Course course = new Course("Pacman - How To Score One Million Points");
			
			// save the course
			System.out.println("Saving the course: " + course);
			session.save(course);
			System.out.println("Saved the course: " + course);
			
			// create the students
			Student firstStudent = new Student("Jan", "Kowalski", "jan@kowalski.com");
			Student secondStudent = new Student("Piotr", "Tracz", "piotr@tracz.com");
			
			// add students to the course
			course.addStudent(firstStudent);
			course.addStudent(secondStudent);
			
			// save the students
			System.out.println("Saving students");
			session.save(firstStudent);
			session.save(secondStudent);
			System.out.println("Saved students: " + course.getStudents());
			
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
