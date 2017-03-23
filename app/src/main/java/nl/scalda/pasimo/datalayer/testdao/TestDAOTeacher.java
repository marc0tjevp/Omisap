package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class TestDAOTeacher implements IDAOTeacher {

	private static TestDAOTeacher instance = null;
	private TreeSet<Teacher> teachers = new TreeSet<>();

	private TestDAOTeacher() {
		Teacher Ma = new Teacher();
		Ma.setFirstName("Max");
		Ma.setEmail("max email");
		Ma.setAbbreviation("Ma");
		Teacher Re = new Teacher();
		Re.setFirstName("Rens");
		Re.setEmail("rens email");
		Re.setAbbreviation("Re");
		Teacher Gi = new Teacher();
		Gi.setFirstName("Gino");
		Gi.setEmail("gino email");
		Gi.setAbbreviation("Gi");
		Teacher Br = new Teacher();
		Br.setFirstName("Bram");
		Br.setEmail("bram email");
		Br.setAbbreviation("Br");
		
		teachers.add(Ma);
		teachers.add(Re);
		teachers.add(Gi);
		teachers.add(Br);
		
		
		
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

	@Override
	public void create(Teacher teacher, EducationTeam team) {
		teachers.add(teacher);
		
	}

	@Override
	public void update(Teacher t, EducationTeam team) {
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
