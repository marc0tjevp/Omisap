package nl.scalda.pasimo.datalayer.testdao;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.TreeSet;

import com.mysql.jdbc.Connection;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class TestDAOStudent implements IDAOStudent {

	public static Connection conn;
	public static Statement statement;
	protected static TestDAOStudent instance = null;
	private TreeSet<Student> students = new TreeSet<>();

	private TestDAOStudent() {

		TreeSet<Note> notelist = new TreeSet<>();

		LessonGroup l1 = new LessonGroup(1, "it's dat lessongroup");
		CoachGroup c1 = new CoachGroup("it's dat boi");

		Student EdgeLord = new Student(69, c1, l1, 420, "you can't stop me", "klaus", "de", "man", 666, 666999420,
				notelist, 42069, 66669);
		Student EdgeLord1 = new Student(622359, c1, l1, 435320, "you cadsafn't stop me", "klaudafs", "dase", "maasdn",
				6636, 6663420, notelist, 4252069, 666169);

		Student s1 = new Student(1111, c1, l1, 2014, "email@example.com", "Bas", "van", "AChternaam", 321, 666999420,
				notelist, 42069, 66669);
		Student s2 = new Student(2222, c1, l1, 2011, "emai1@example.com", "Baas", "van", "Wie", 123, 6663420, notelist,
				4252069, 666169);

		students.add(EdgeLord);
		students.add(EdgeLord1);
		students.add(s1);
		students.add(s2);
	}

	public static TestDAOStudent getInstance() {
		if (instance == null) {
			instance = new TestDAOStudent();
		}
		return instance;
	}

	@Override
	public void delete(Student s) {
		students.remove(s);
	}

	@Override
	public void create(Student s) {
		students.add(s);
	}

	@Override
	public void update(Student st) {
		for (Student s : students) {
			if (st.compareTo(s) == 0) {
				s.setCardID(st.getCardID());
				s.setCoachGroup(st.getCoachGroup());
				s.setCohort(st.getCohort());
				s.setDateOfBirth(st.getDateOfBirth());
				s.setEmail(st.getEmail());
				s.setFirstName(st.getFirstName());
				s.setInsertion(st.getInsertion());
				s.setLastName(st.getLastName());
				s.setLessonGroup(st.getLessonGroup());
				s.setNoteList(st.getNoteList());
				s.setStudentOV(st.getStudentOV());
			}
		}
	}

	@Override
	public Student readByOvNumber(int ov) {
		for (Student s : this.students) {
			if (ov != s.getStudentOV()) {
				continue;
			}
			return s;
		}

		return null;
	}

	@Override
	public TreeSet<Student> readAll() {
		return new TreeSet<Student>(students);
	}

	@Override
	public TreeSet<Student> readAllByLessonGroup(LessonGroup lessonGroup) {
		TreeSet<LessonGroup> lessonGroups = DAOFactory.getTheFactory().getDAOLessonGroup().readAll();

		for (LessonGroup loopingLessonGroup : lessonGroups) {
			if (lessonGroup != loopingLessonGroup) {
				continue;
			}
			return loopingLessonGroup.getStudents();

		}
		return null;
	}
}