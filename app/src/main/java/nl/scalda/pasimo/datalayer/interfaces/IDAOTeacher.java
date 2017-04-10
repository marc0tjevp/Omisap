package nl.scalda.pasimo.datalayer.interfaces;

import java.util.List;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public interface IDAOTeacher {
	
    public void create(Teacher teacher);

    public void update(Teacher t);

    public void delete(Teacher t);

    public List<Teacher> readAll();

    public Teacher readByEmployeeNumber(int employeeNumber);

    public TreeSet<Teacher> readAllForEducationTeam(EducationTeam t);

	public Teacher readByAbbr(String abbreviation);
	
	public EducationTeam getCurrentEducationTeamOfTeacher(Teacher teacher);
	
	public CoachGroup getCurrentCoachGroup(Teacher teacher);

}
