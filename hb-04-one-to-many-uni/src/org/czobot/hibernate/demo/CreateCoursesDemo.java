package org.czobot.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.czobot.hibernate.demo.entity.Course;
import org.czobot.hibernate.demo.entity.Instructor;
import org.czobot.hibernate.demo.entity.InstructorDetail;
import org.czobot.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the instructor form db
			int instructorId = 1;
			Instructor instructor = session.get(Instructor.class, instructorId);
			
			// create some courses
			Course firstCourse = new Course("The Pinball Masterclass");
			Course secondCourse = new Course("Air Guitar");
			
			// add courses to instructor
			instructor.add(firstCourse);
			instructor.add(secondCourse);
			
			// save the courses
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
