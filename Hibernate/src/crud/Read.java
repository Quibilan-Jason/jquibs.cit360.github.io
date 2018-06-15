package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Read {

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
			System.out.println("Brah. creating new student object...");
			Student tempStudent = new Student("Ginny", "Weasley", "gweasley@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Brah, saving the student...");
			System.out.println(tempStudent);
			
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
						
			// find out the student's id
			System.out.println("Brah, student saved. Generated id: " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nBrah, getting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Brah, got it: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("All Pau!!!");
		}
		finally {
			factory.close();
		}
	}

}






