package nl.scalda.pasimo.datalayer;

import java.util.TreeSet;
import nl.scalda.pasimo.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.EducationTeam;
import nl.scalda.pasimo.model.Teacher;

public class TestDAOTeacher implements IDAOTeacher {

	private static TestDAOTeacher instance = null;
	private TreeSet<Teacher> teachers = new TreeSet<>();

	private TestDAOTeacher() {}

	@Override
	public void create(Teacher t, EducationTeam team) {
		teachers.add(t);
	}

	@Override
	public void edit(Teacher t, EducationTeam team, String oldAbbr) {
		for(Teacher ca : teachers){
			if(ca.getAbbreviation().equals(oldAbbr)){
				ca.setAbbreviation(t.getAbbreviation());
				ca.setCardID(t.getCardID());
				ca.setEmployeeNumber(t.getEmployeeNumber());
				ca.setFirstName(t.getFirstName());
				ca.setInsertion(t.getInsertion());
				ca.setLastName(t.getLastName());
				ca.setEmail(t.getEmail());
				ca.setDateOfBirth(t.getDateOfBirth());
			}
		}
	}

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

}
