package nl.scalda.pasimo.datalayer.mysqldao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import com.mysql.jdbc.Connection;

import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class MYSQLDAOStudent implements IDAOStudent {

	public static Connection conn;
	public static Statement statement;
	protected static MYSQLDAOStudent instance = null;
	private TreeSet<Student> students = new TreeSet<>();

	private MYSQLDAOStudent() {

	}

	public static MYSQLDAOStudent getInstance() {
		if (instance == null) {
			instance = new MYSQLDAOStudent();
		}
		return instance;
	}


	@Override
	public void delete(Student s) {
		int studentOV = s.getStudentOV();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDAO", "root", "");

			// the mysql insert statement
			String query = " delete from student where studentOV = (?)";
			// create the mysql insert preparedstatement
			java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, studentOV);
			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void create(Student s) {
		Person p = s;
		int studentOV = s.getStudentOV();
		String coachGroup = s.getNameOfCoachGroup();
		String lessonGroup = s.getNameOfLessonGroup();
		int cohort = s.getCohort();
		String email = s.getEmail();
		String firstName = s.getFirstName();
		String insertion = s.getInsertion();
		String lastName = s.getLastName();
		int cardID = s.getCardID();
		String DateOfBirth = p.getDateOfBirthInString();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDAO", "root", "");

			// the mysql insert statement
			String query = " insert into student (studentOV, coachGroup, lessongroup, cohort, email, firstName, insertion, lastName, cardID, yearOfBirth, monthOfBirth, dayOfBirth)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, coachGroup);
			preparedStmt.setString(2, lessonGroup);
			preparedStmt.setInt(3, cohort);
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, firstName);
			preparedStmt.setString(6, insertion);
			preparedStmt.setString(7, lastName);
			preparedStmt.setInt(8, cardID);
			preparedStmt.setString(9, DateOfBirth);
			preparedStmt.setInt(10 , studentOV);
			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Student s) {
		Person p = s;
		int studentOV = s.getStudentOV();
		String coachGroup = s.getNameOfCoachGroup();
		String lessonGroup = s.getNameOfLessonGroup();
		int cohort = s.getCohort();
		String email = s.getEmail();
		String firstName = s.getFirstName();
		String insertion = s.getInsertion();
		String lastName = s.getLastName();
		int cardID = s.getCardID();
		String DateOfBirth = p.getDateOfBirthInString();


		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDAO", "root", "");

			// the mysql insert statement
			String query = " UPDATE student set coachGroup = (?) , lessongroup = (?) , cohort = (?) , email = (?) , firstName = (?) , insertion = (?) , lastName = (?) , cardID = (?) , "
					+ "DateOfBirth where studentOV = (?)";

			// create the mysql insert preparedstatement
			java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, coachGroup);
			preparedStmt.setString(2, lessonGroup);
			preparedStmt.setInt(3, cohort);
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, firstName);
			preparedStmt.setString(6, insertion);
			preparedStmt.setString(7, lastName);
			preparedStmt.setInt(8, cardID);
			preparedStmt.setString(9, DateOfBirth);
			preparedStmt.setInt(10 , studentOV);
			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Student readByOvNumber(int ov) {
		try {
			// create the mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/StudentDAO";
			Class.forName(myDriver);
			java.sql.Connection conn = DriverManager.getConnection(myUrl, "root", "");

			// create the mysql delete statement.
			String query = "select from `studentdao`.`student` where studentOV = (?)";
			java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, ov);

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public TreeSet<Student> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}