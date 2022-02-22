package org.czobot.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.czobot.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			displayStudents(students);
			
			// query students: lastName='Kowalski'
			students = session.createQuery("from Student s where s.lastName='Kowalski'").getResultList();
			
			System.out.println("\n\nStudents with lastName: Kowalski");
			displayStudents(students);
			
			// query students: lastName='Kowalski' OR firstName='Piotr'
			students = session.createQuery("from Student s where lastName='Kowalski' OR s.firstName='Piotr'").getResultList();
			
			System.out.println("\n\nStudents with lastName Kowalski OR firstName Piotr");
			displayStudents(students);
			
			// query students where email LIKE '%kowalski.com'
			students = session.createQuery("from Student s where s.email LIKE '%kowalski.com'").getResultList();
			
			System.out.println("\n\nStudents with email LIKE '%kowalski.com'");
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		// display the students
		for(Student student : students) {
			System.out.println(student);
		}
	}

}
