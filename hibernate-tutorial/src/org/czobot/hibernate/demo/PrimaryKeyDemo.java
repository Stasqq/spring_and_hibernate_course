package org.czobot.hibernate.demo;

import org.czobot.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student objects
			System.out.println("Creating 3 student objects");
			Student student1 = new Student("Jan", "Kowalski", "jan@kowalski.com");
			Student student2 = new Student("Piotr", "Wojciechowski", "piotr@wojciechowski.com");
			Student student3 = new Student("Tomasz", "Górniak", "tomasz@gorniak.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("Saving students");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
