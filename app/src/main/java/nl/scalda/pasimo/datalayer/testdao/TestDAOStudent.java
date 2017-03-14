package nl.scalda.pasimo.datalayer.testdao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import com.mysql.jdbc.Connection;
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
	
	public void addtodatabase(Student s) throws SQLException{
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
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDAO", "root", "skullcandy1" ); 
	 statement = conn.createStatement();
	 
	 statement.executeUpdate("INSERT INTO student " + "VALUES (" + studentOV + "," + coachGroupID + "," + lessonGroupID + "," + cohort + "," + email + "," + firstName + "," + insertion + "," + lastName + "," + cardID + "," + yearOfBirth  + "," + noteListID + "," + monthOfBirth +"," + dayOfBirth + ");");
	 
	}
	
	@Override
	public void delete(Student s) {
		if (students.remove(s)) {
			DAOFactory.getTheFactory().getDAOStudent().delete(s);
		}
	}

	@Override
	public void create(Student s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Student s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student readByOvNumber(int ov) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Student> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}