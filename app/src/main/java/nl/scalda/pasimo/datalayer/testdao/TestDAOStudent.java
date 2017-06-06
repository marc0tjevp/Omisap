package nl.scalda.pasimo.datalayer.testdao;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
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
	
	@Override
	public TreeSet<Student> readAll() {
		return students;
	}

	public TreeSet<Student> getStudents() {
		return students;
	}

	public void setStudents(TreeSet<Student> students) {
		
		this.students = students;
	}

	@Override
	public void update(Student s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student readByStudentOV(int StudentOV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Student> readAllForEducationTeam(EducationTeam t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EducationTeam getCurrentEducationTeamOfStudent(Student Student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoachGroup getCurrentCoachGroup(Student Student) {
		// TODO Auto-generated method stub
		return null;
	}

}
