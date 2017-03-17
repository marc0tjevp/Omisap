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

	public void addtodatabase(Student s) throws SQLException {

	}

	@Override
	public void delete(Student s) {

		try {
			int ovnumber = s.getStudentOV();
			// create the mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost";
			Class.forName(myDriver);
			java.sql.Connection conn = DriverManager.getConnection(myUrl, "root", "");

			// create the mysql delete statement.
			String query = "delete from `studentdao`.`student` where studentOV = ?";
			java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, ovnumber);

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {

		}

	}

	@Override
	public void create(Student s) {
		int studentOV = s.getStudentOV();
		int coachGroupID = s.getCoachGroupID();
		int lessonGroupID = s.getLessonGroupID();
		int cohort = s.getCohort();
		String email = s.getEmail();
		String firstName = s.getFirstName();
		String insertion = s.getInsertion();
		String lastName = s.getLastName();
		int cardID = s.getCardID();
		int yearOfBirth = s.getYearOfBirth();
		int noteListID = s.getNoteListID();
		int monthOfBirth = s.getMontOfBirth();
		int dayOfBirth = s.getDayOfBirth();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		java.sql.Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDAO", "root", "skullcandy1");
			statement = conn.createStatement();

			statement.executeUpdate(
					"INSERT INTO `studentdao`.`student` (`studentOV`, `coachgroupID`, `lessongroupID`, `cohort`, `email`, `firstname`, "
							+ "`insertion`, `lastname`, `cardID`, `yearofbirth`, `notelistID`, `monthofbirth`, `dayofbirth`) VALUES "
							+ "('" + studentOV + "','" + coachGroupID + "','" + lessonGroupID + "','" + cohort + "', '"
							+ email + "','" + firstName + "','" + insertion + "','" + lastName + "','" + cardID + "','"
							+ yearOfBirth + "','" + noteListID + "','" + monthOfBirth + "','" + dayOfBirth + "');");

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Student s) {

	}

	@Override
	public void readByOvNumber(int ov) {
		try {
			// create the mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost";
			Class.forName(myDriver);
			java.sql.Connection conn = DriverManager.getConnection(myUrl, "root", "");

			// create the mysql delete statement.
			String query = "delete from `studentdao`.`student` where studentOV = ?";
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