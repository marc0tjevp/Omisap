package nl.scalda.pasimo.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeeManagement.EducationTeam;
import nl.scalda.pasimo.model.employeeManagement.Teacher;

public interface IDAOTeacher {
	
    public void add(Teacher teacher, EducationTeam team);

    public void edit(Teacher t, EducationTeam team, String oldAbbr);

    public void delete(Teacher t, EducationTeam team);

    public TreeSet<Teacher> readAll();

    public Teacher readByAbbr(String id);

    public TreeSet<Teacher> readAllForEducationTeam(EducationTeam t);

}
