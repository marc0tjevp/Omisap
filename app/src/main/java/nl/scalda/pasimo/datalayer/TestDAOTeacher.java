package nl.scalda.pasimo.datalayer;

import java.util.TreeSet;

import nl.scalda.pasimo.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class TestDAOTeacher implements IDAOTeacher {

	private static TestDAOTeacher instance = null;
	private TreeSet<Teacher> teachers = new TreeSet<>();

	private TestDAOTeacher() {}

	@Override
	public void create(Teacher t, EducationTeam team) {
		teachers.add(t);
	}

	@Override
	public void update(Teacher t, EducationTeam team) {
		for(Teacher ca : teachers){
			if(ca.getEmployeeNumber() == t.getEmployeeNumber()){
				ca.setCardID(t.getCardID());
				ca.setFirstName(t.getFirstName());
				ca.setInsertion(t.getInsertion());
				ca.setLastName(t.getLastName());
				ca.setEmail(t.getEmail());
				ca.setAbbreviation();
			}
		}
		
	}

	@Override
	public void delete(Teacher t, EducationTeam team) {
		teachers.remove(t);

	}

	@Override
	public Teacher readByEmployeeNumber(int id) {
		for (Teacher ca : teachers) {
			if (ca.getEmployeeNumber() == id) {
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
	public Teacher readByAbbr(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
