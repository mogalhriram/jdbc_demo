package JavaJDBC.JDBC.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	static Connection connection;

	public static boolean insertStudentToDB(Student student) {
		boolean flag = false;
		try {
			connection = ConnectionProvider.createConnection();
			// use prepared statement
			String query = "insert into students(sname,sphone,scity) values(?,?,?)";
			PreparedStatement prst = connection.prepareStatement(query);
			// set values of parameters
			prst.setString(1, student.getsName());
			prst.setString(2, student.getsPhone());
			prst.setString(3, student.getsCity());
			prst.executeUpdate();
			connection.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public static Boolean deleteStudentFromDB(int sid) {
		Boolean flag = false;
		try {
			connection = ConnectionProvider.createConnection();
			// use prepared statement
			String query = "delete from students where sid=?";
			PreparedStatement prst = connection.prepareStatement(query);
			prst.setInt(1, sid);
			prst.executeUpdate();
			connection.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static Boolean showAllStudents() {
		Boolean flag = false;
		try {
			connection = ConnectionProvider.createConnection();
			String query = "select * from students;";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query);
			while (set.next()) {
				int sid = set.getInt(1);
				String sName = set.getString(2);
				String sPhone = set.getString(3);
				String sCity = set.getString(4);
				System.out.print("| sid: " + sid);
				System.out.print(" | sname: " + sName);
				System.out.print(" | sphone: " + sPhone);
				System.out.println(" | scity: " + sCity + " |");
				System.out.println("---------------------------");
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static Boolean updateStudentName(int sid, String sName) {
		Boolean flag = false;
		try {
			connection = ConnectionProvider.createConnection();
			// use prepared statement
			String query = "update students set sname=? where sid=?;";
			PreparedStatement prst = connection.prepareStatement(query);
			// set values of parameters
			prst.setString(1, sName);
			prst.setInt(2, sid);
			prst.executeUpdate();
			connection.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
