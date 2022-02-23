package org.czobot.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.czobot.hibernate.demo.entity.Course;
import org.czobot.hibernate.demo.entity.Instructor;
import org.czobot.hibernate.demo.entity.InstructorDetail;
import org.czobot.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

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
			// create the objects
			Instructor instructor = new Instructor("Zuzanna", "Kowalsksa", "zuzanna@kowalska.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("https://www.kowalska.com/youtube",
																	"Gaming");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			// this will ALSO save the details object, because of CascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);	
			
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
