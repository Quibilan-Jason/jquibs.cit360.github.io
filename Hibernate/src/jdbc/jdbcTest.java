package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcTest {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/student_tracker?useSSL=false";
		String user = "root";
		String pass = "hawaii";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Brah, connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}




