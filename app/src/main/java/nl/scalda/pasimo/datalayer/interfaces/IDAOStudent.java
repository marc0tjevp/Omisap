package nl.scalda.pasimo.datalayer.interfaces;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.Student;

public interface IDAOStudent {
	public void create(Student s);
	public void createAll(Set<Student> student);
	public Set<Student> readAll();
}
