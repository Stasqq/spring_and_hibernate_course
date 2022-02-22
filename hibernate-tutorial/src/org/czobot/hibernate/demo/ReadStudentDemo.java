package org.czobot.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.czobot.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object");
			Student createdStudent = new Student("Jakub", "Kowalski", "jakub@kowalski.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("Saving student");
			System.out.println(createdStudent);
			session.save(createdStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Saved student Genereted id: " + createdStudent.getId());
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + createdStudent.getId());
			
			Student readStudent = session.get(Student.class, createdStudent.getId());
			
			System.out.println("Get complete: " + readStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
