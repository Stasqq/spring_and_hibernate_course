package org.czobot.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.czobot.hibernate.demo.entity.Instructor;
import org.czobot.hibernate.demo.entity.InstructorDetail;
import org.czobot.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int id = 4;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			// print instructor detail
			System.out.println("Found instructorDetail: " + instructorDetail);
			
			// print associated instructor
			System.out.println("Associated instructor: " + instructorDetail.getInstructor());
			
			// now delete the instructor detail
			System.out.println("Deleting instrcutorDetail: " + instructorDetail);
			
			// remove the associated object reference
			// break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
