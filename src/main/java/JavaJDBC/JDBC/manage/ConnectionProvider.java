package JavaJDBC.JDBC.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static Connection connection;

	public static Connection createConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root",
					"Fresher@Persistent1931");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
