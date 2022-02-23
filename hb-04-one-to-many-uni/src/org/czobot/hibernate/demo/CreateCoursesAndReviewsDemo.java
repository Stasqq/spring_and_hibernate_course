package org.czobot.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.czobot.hibernate.demo.entity.Course;
import org.czobot.hibernate.demo.entity.Instructor;
import org.czobot.hibernate.demo.entity.InstructorDetail;
import org.czobot.hibernate.demo.entity.Review;
import org.czobot.hibernate.demo.entity.Student;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course course = new Course("Pacman - How To Score One Million Points");
			
			// add some reviews
			course.addReview(new Review("Greate course!"));
			course.addReview(new Review("Cool course!"));
			course.addReview(new Review("Preety nice course!"));
			
			// save the course .. and leverage the cascade all
			System.out.println("Saving the course: " + course);
			System.out.println(course.getReviews());
			session.save(course);
			
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
