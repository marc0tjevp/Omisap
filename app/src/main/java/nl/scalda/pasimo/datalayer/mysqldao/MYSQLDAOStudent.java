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

	}

	@Override
	public void create(Student s) {

	}

	@Override
	public void update(Student s) {

	}

	@Override
	public Student readByOvNumber(int ov) {

		return null;
	}

	@Override
	public TreeSet<Student> readAll() {
		return null;
	}
}