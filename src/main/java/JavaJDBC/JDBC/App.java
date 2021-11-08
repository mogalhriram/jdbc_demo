package JavaJDBC.JDBC;

import java.util.Scanner;

import JavaJDBC.JDBC.manage.Student;
import JavaJDBC.JDBC.manage.StudentDao;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome To Student Management System");
		while (true) {
			System.out.println("Press 1 to add student");
			System.out.println("Press 2 to delete student");
			System.out.println("Press 3 to show students");
			System.out.println("Press 4 to update student");
			System.out.println("press 5 to exit the app");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				addStudent();
				break;
			case 2:
				deleteStudent();
				break;
			case 3:
				showStudents();
				break;
			case 4:
				upadteStudent();
				break;
			case 5:
				System.out.println("Thank You for using Application! See You Soon");
				sc.close();
				return;
			default:
				System.out.println("Select Proper Option");
			}
		}
	}

	private static void upadteStudent() {
		Boolean flag;
		System.out.println("Enter student id");
		int sid = sc.nextInt();
		System.out.println("Press 1 to update Name");
		// Create Method for following
		System.out.println("Press 2 to update Phone");
		System.out.println("Press 3 to update city");
		int option = sc.nextInt();
		if (option == 1) {
			System.out.println("Enter Student Name");
			String name = sc.next();
			flag = StudentDao.updateStudentName(sid, name);
			if (flag)
				System.out.println("Updated");
			else
				System.out.println("Error occured");
		}

	}

	private static void showStudents() {
		Boolean flag = StudentDao.showAllStudents();
		if (!flag)
			System.out.println("Error Occured");
	}

	private static void deleteStudent() {
		System.out.println("Enter student id");
		int sid = sc.nextInt();
		Boolean flag = StudentDao.deleteStudentFromDB(sid);
		if (flag)
			System.out.println("Student Deleted with id " + sid);
		else
			System.out.println("Error occured");
	}

	private static void addStudent() {
		System.out.println("Enter Student Name");
		String sName = sc.next();
		System.out.println("Enter Phone Number");
		String sPhone = sc.next();
		System.out.println("Enter city");
		String sCity = sc.next();
		Student student = new Student(sName, sPhone, sCity);
		Boolean flag = StudentDao.insertStudentToDB(student);
		if (flag) {
			System.out.println("Added" + student);
		} else
			System.out.println("Error Occured");

	}
}
