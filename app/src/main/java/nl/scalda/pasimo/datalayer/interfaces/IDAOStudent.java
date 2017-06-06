package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Student;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public interface IDAOStudent {
	
	   public void create(Student student);

	    public void update(Student s);

	    public void delete(Student s);

	    public TreeSet<Student> readAll();

	    public Student readByOVNumber(int StudentOV);

	    public TreeSet<Student> readAllForLessonGroup(LessonGroup l);
	    
	    public TreeSet<Student> readAllForCoachGroup(CoachGroup c);
		
		public EducationTeam getCurrentCoachGroupOfStudent(Student student);
		
		public EducationTeam getCurrentLessonGroupOfStudent(Student student);

}
