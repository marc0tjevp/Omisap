package nl.scalda.pasimo.datalayer.testdao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class TestDAOTeacher implements IDAOTeacher {

	private static TestDAOTeacher instance = null;
	private List<Teacher> teachers = new ArrayList<Teacher>();

	/**
	 * default constructor.
	 */
	private TestDAOTeacher() {}

	/**
	 * deletes the teacher from the teachers collection.
	 * 
	 * @param Teacher t
	 */
	@Override
	public void delete(Teacher t) {
		teachers.remove(t);

	}

	/**
	 * returns all teachers.
	 * 
	 * @return TreeSet<Teacher>
	 */
	@Override
	public List<Teacher> readAll() {
		return teachers;
	}

	/**
	 * returns all teachers in the given education team.
	 * 
	 * @param EducationTeam t
	 * @return TreeSet<teacher>
	 */
	@Override
	public TreeSet<Teacher> readAllForEducationTeam(EducationTeam t) {
		TreeSet<Teacher> teachers = new TreeSet<>();
		for(Teacher te : t.getTeachers()){
			teachers.add(te);
		}
		return teachers;
	}

	/**
	 * adds the teacher to the teachers collection.
	 * 
	 * @param Teacher teacher
	 */
	@Override
	public void create(Teacher teacher) {
		teachers.add(teacher);
		
	}

	/**
	 * updated the teacher.
	 * 
	 * @param Teacher t
	 */
	@Override
	public void update(Teacher t) {
		//no need for an update method.
		}

	/**
	 * returns the teacher that has the given employeeNumber.
	 * 
	 * @param int employeeNumber
	 * @return Teacher
	 */
	@Override
	public Teacher readByEmployeeNumber(int employeeNumber) {
		for(Teacher t : teachers){
			if(t.getEmployeeNumber() == employeeNumber){
				return t;
			}
		}
		return null;
	}

	/**
	 * gets the education team the given teacher is currently in.
	 * 
	 * @param Teacher teacher
	 * @return EducationTeam
	 */
	@Override
	public EducationTeam getCurrentEducationTeamOfTeacher(Teacher teacher) {
		//TODO need collection of all educationteams before this method can be written
		return null;
	}

	/**
	 * gets the coach group the given teacher is currently in.
	 * 
	 * @param Teacher teacher
	 * @return CoachGroup
	 */
	@Override
	public CoachGroup getCurrentCoachGroup(Teacher teacher) {
		// TODO need collection of all coachgroups before this method can be written
		return null;
	}
	
	/**
	 * check if there is already an instance of this class and returns it.
	 * 
	 * @return TestDAOTeacher
	 */
	public static TestDAOTeacher getInstance() {
		if (instance == null) {
			instance = new TestDAOTeacher();
		}
		return instance;
	}
	
}
