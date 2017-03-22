package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public interface IDAOTeacher {
	
    public void create(Teacher teacher, EducationTeam team);

    public void update(Teacher t, EducationTeam team);

    public void delete(Teacher t, EducationTeam team);

    public TreeSet<Teacher> readAll();

    public Teacher readByEmployeeNumber(int id);

    public TreeSet<Teacher> readAllForEducationTeam(EducationTeam t);

	public Teacher readByAbbr(String id);

}
