package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

public interface IDAOStudent {
	
    public Student create(Student studeent);

    public Student update(Student s);

    public Student delete(Student s);

    public TreeSet<Student> readAll();

    public TreeSet<Student> readAllForLessonGroup(LessonGroup l);
	
	public LessonGroup getCurrentLessonGroup(Student student);

	public Student readByStudentOV(int studentOV);



}
