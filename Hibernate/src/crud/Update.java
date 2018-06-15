package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Update {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {								
			int studentId = 1;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id
			System.out.println("\nBrah, getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Bruh, updating student...");
			myStudent.setFirstName("Wakanda");
			
			
			session.getTransaction().commit();

						
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email
			System.out.println("Brah, update email for all students");
			
			session.createQuery("update Student set email='skywalker@gmail.com'")
				.executeUpdate();
						
			session.getTransaction().commit();

			
			System.out.println("All Pau!!!");
		}
		finally {
			factory.close();
		}
	}

}






