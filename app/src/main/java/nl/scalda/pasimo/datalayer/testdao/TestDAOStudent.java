package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class TestDAOStudent implements IDAOStudent {
	private static TestDAOStudent instance;
	public TreeSet<Student> students = new TreeSet<>();
	public TestDAOStudent(){
		
	}
	
    public static TestDAOStudent getInstance() {
        if (instance == null) {
            instance = new TestDAOStudent();
        }
        return instance;
    }

	@Override
	public void create(Student s) {
		students.add(s);
		
	}

	public TreeSet<Student> getStudents() {
		return students;
	}

	public void setStudents(TreeSet<Student> students) {
		this.students = students;
	}
	
}
