package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

public interface IDAOStudent {

	public void create(Student s);

	public void update(Student s);

	public void delete(Student s);

	public Student readByOvNumber(int ov);
	
    public TreeSet<Student> readAllByLessonGroup(LessonGroup lessonGroup);

	public TreeSet<Student> readAll();
}