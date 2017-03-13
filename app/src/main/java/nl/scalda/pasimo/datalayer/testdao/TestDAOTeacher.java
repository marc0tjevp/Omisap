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
	public void delete(Teacher t) {
		teachers.remove(t);

	}

	@Override
	public Teacher readByAbbr(String employeeNumber) {
		for (Teacher ca : teachers) {
			if (ca.getAbbreviation().equals(employeeNumber)) {
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
	public void create(Teacher teacher) {
		teachers.add(teacher);
		
	}

	@Override
	public void update(Teacher t) {
		for(Teacher ca : teachers){
//			if(ca.getAbbrevation().equals(oldAbbr)){
//				ca.setAbbrevation(t.getAbbrevation());
//				ca.setCardID(t.getCardID());
//				ca.setEmployeeNumber(t.getEmployeeNumber());
//				ca.setFirstName(t.getFirstName());
//				ca.setInsertion(t.getInsertion());
//				ca.setLastName(t.getLastName());
//				ca.setEmail(t.getEmail());
//				ca.setDateOfBirth(t.getDateOfBirth());
//			}
		}
		
	}

	@Override
	public Teacher readByEmployeeNumber(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
