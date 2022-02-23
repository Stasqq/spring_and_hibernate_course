package org.czobot.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.czobot.hibernate.demo.entity.Instructor;
import org.czobot.hibernate.demo.entity.InstructorDetail;
import org.czobot.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
//			Instructor instructor = new Instructor("Jan", "Kowalski", "jan@kowalski.com");
//			
//			InstructorDetail instructorDetail = new InstructorDetail("https://www.kowalski.com/youtube",
//																	"Programming");
			
			Instructor instructor = new Instructor("Piotr", "Tracz", "piotr@tracz.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("https://www.tracz.com/youtube",
																	"Swimming");
			
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
			factory.close();
		}
	}

}
