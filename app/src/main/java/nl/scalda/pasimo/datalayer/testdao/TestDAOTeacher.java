package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class TestDAOTeacher implements IDAOTeacher {

	private static TestDAOTeacher instance = null;
	private TreeSet<Teacher> teachers = new TreeSet<>();

	private TestDAOTeacher() {}

	@Override
	public void delete(Teacher t, EducationTeam team) {
		teachers.remove(t);

	}

	@Override
	public Teacher readByAbbr(String id) {
		for (Teacher ca : teachers) {
			if (ca.getAbbreviation().equals(id)) {
				return ca;
			}
		}
		return null;
	}

	@Override
	public TreeSet<Teacher> readAll() {
		return teachers;
	}

	@Override
	public TreeSet<Teacher> readAllForEducationTeam(EducationTeam t) {
		return null;
	}

	public static TestDAOTeacher getInstance() {
		if (instance == null) {
			instance = new TestDAOTeacher();
		}
		return instance;
	}

	@Override
	public void create(Teacher teacher, EducationTeam team) {
		teachers.add(teacher);
		
	}

	@Override
	public void update(Teacher t, EducationTeam team) {
		// TODO what is the meaning of this method? Implement or remove. Beware: it overrides another method.

		
	}

	@Override
	public Teacher readByEmployeeNumber(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
