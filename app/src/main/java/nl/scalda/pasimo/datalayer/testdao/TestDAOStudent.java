package nl.scalda.pasimo.datalayer.testdao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class TestDAOStudent implements IDAOStudent {

	public static Connection conn;
	public static Statement statement;
	protected static TestDAOStudent instance = null;
	private TreeSet<Student> students = new TreeSet<>();

	private TestDAOStudent() {

	}

	public static TestDAOStudent getInstance() {
		if (instance == null) {
			instance = new TestDAOStudent();
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
		int studentOV = s.getStudentOV();
		String coachGroup = s.getNameOfCoachGroup();
		String lessonGroup = s.getNameOfLessonGroup();
		int cohort = s.getCohort();
		String email = s.getEmail();
		String firstName = s.getFirstName();
		String insertion = s.getInsertion();
		String lastName = s.getLastName();
		int cardID = s.getCardID();
		int yearOfBirth = s.getYearOfBirth();
		int monthOfBirth = s.getMontOfBirth();
		int dayOfBirth = s.getDayOfBirth();

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
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, studentOV);
			preparedStmt.setString(2, coachGroup);
			preparedStmt.setString(3, lessonGroup);
			preparedStmt.setInt(4, cohort);
			preparedStmt.setString(5, email);
			preparedStmt.setString(6, firstName);
			preparedStmt.setString(7, insertion);
			preparedStmt.setString(8, lastName);
			preparedStmt.setInt(9, cardID);
			preparedStmt.setInt(10, yearOfBirth);
			preparedStmt.setInt(11, monthOfBirth);
			preparedStmt.setInt(12, dayOfBirth);
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
		int studentOV = s.getStudentOV();
		String coachGroup = s.getNameOfCoachGroup();
		String lessonGroup = s.getNameOfLessonGroup();
		int cohort = s.getCohort();
		String email = s.getEmail();
		String firstName = s.getFirstName();
		String insertion = s.getInsertion();
		String lastName = s.getLastName();
		int cardID = s.getCardID();
		int yearOfBirth = s.getYearOfBirth();
		int monthOfBirth = s.getMontOfBirth();
		int dayOfBirth = s.getDayOfBirth();

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
					+ "yearOfBirth = (?) , monthOfBirth = (?) , dayOfBirth = (?) where studentOV = (?)";

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
			preparedStmt.setInt(9, yearOfBirth);
			preparedStmt.setInt(10, monthOfBirth);
			preparedStmt.setInt(11, dayOfBirth);
			preparedStmt.setInt(12, studentOV);
			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void readByOvNumber(int ov) {
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

	}

	@Override
	public TreeSet<Student> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}