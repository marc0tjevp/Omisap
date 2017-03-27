package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;


import nl.scalda.pasimo.model.employeemanagement.CoachGroup;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class TestDAOTeacher implements IDAOTeacher {

	private static TestDAOTeacher instance = null;
	private TreeSet<Teacher> teachers = new TreeSet<>();


	private TestDAOTeacher() {
		Teacher ma = new Teacher();
		ma.setFirstName("Max");
		ma.setEmail("max email");
		ma.setAbbreviation("Ma");
		Teacher re = new Teacher();
		re.setFirstName("Rens");
		re.setEmail("rens email");
		re.setAbbreviation("Re");
		Teacher gi = new Teacher();
		gi.setFirstName("Gino");
		gi.setEmail("gino email");
		gi.setAbbreviation("Gi");
		Teacher br = new Teacher();
		br.setFirstName("Bram");
		br.setEmail("bram email");
		br.setAbbreviation("Br");
		
		teachers.add(ma);
		teachers.add(re);
		teachers.add(gi);
		teachers.add(br);
		
		
		
	}
	/**
	 * default constructor.
	 */



	/**
	 * deletes the teacher from the teachers collection.
	 * 
	 * @param Teacher t
	 */

	public void delete(Teacher t) {
		teachers.remove(t);

	}

	/**
	 * returns the teacher that has the given abbreviation.
	 * 
	 * @param String abbreviation
	 * @return Teacher
	 */
	@Override
	public Teacher readByAbbr(String abbreviation) {
		for (Teacher ca : teachers) {
			if (ca.getAbbreviation().equals(abbreviation)) {
				return ca;
			}
		}
		return null;
	}

	/**
	 * returns all teachers.
	 * 
	 * @return TreeSet<Teacher>
	 */
	@Override
	public TreeSet<Teacher> readAll() {
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
		return null;
	}

	/**
	 * adds the teacher to the teachers collection.
	 * 
	 * @param Teacher teacher
	 */

	public void create(Teacher teacher) {
		teachers.add(teacher);
		
	}

	/**
	 * updated the teacher.
	 * 
	 * @param Teacher t
	 */

	public void update(Teacher t) {
		// TODO implement this method

		}

	/**
	 * returns the teacher that has the given employeeNumber.
	 * 
	 * @param int employeeNumber
	 * @return Teacher
	 */
	@Override
	public Teacher readByEmployeeNumber(int employeeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * gets the education team the given teacher is currently in.
	 * 
	 * @param Teacher teacher
	 * @return EducationTeam
	 */

	public EducationTeam getCurrentEducationTeamOfTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * gets the coach group the given teacher is currently in.
	 * 
	 * @param Teacher teacher
	 * @return CoachGroup
	 */

	public CoachGroup getCurrentCoachGroup(Teacher teacher) {
		// TODO Auto-generated method stub
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
	@Override
	public void create(Teacher teacher, EducationTeam team) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Teacher t, EducationTeam team) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Teacher t, EducationTeam team) {
		// TODO Auto-generated method stub
		
	}
	
}
