package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Create {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create students
			System.out.println("Brah, creating new student object...");
			Student tempStudent1 = new Student("Harry", "Potter", "hpotter@gmail.com");
			Student tempStudent2 = new Student("Ron", "Weasley", "rweasley@gmail.com");
			Student tempStudent3 = new Student("Hermoine", "Granger", "hgranger@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Brah, saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("All Pau!!!");
		}
		finally {
			factory.close();
		}
	}

}






