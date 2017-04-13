package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Student;

public interface IDAOStudent {
	
    public void create(Student student);

    public void update(Student t);

    public void delete(Student t);

    public TreeSet<Student> readAll();

    public Student readByCardID(int CardID);

    public TreeSet<Student> readAllForEducationTeam(EducationTeam t);
	
	public EducationTeam getCurrentEducationTeamOfStudent(Student Student);
	
	public CoachGroup getCurrentCoachGroup(Student Student);

}
