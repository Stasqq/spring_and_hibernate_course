package org.czobot.hibernate.demo;

import org.czobot.hibernate.demo.entity.Course;
import org.czobot.hibernate.demo.entity.Instructor;
import org.czobot.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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
			
			// hibernate query with HQL
			
			int instructorId = 1;
			
			Query<Instructor> query =
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id =: theInstructorId",
					Instructor.class);
			
			query.setParameter("theInstructorId", instructorId);
			
			// execute query and get the instuctor
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Instructor: " + instructor);
			
			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();
			
			// get courses for the instructor
			System.out.println("Courses: " + instructor.getCourses());
			
			System.out.println("Done!");
		}
		finally {
			// add clean code
			session.close();
			
			factory.close();
		}
	}

}
