package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Delete {

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
									
			// delete student id=2
			System.out.println("Brah, deleting student id=2");
			
			session.createQuery("delete from Student where id=1").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("All Pau!!!");
		}
		finally {
			factory.close();
		}
	}

}





