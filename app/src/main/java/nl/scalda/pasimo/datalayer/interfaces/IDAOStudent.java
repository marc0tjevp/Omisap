package nl.scalda.pasimo.datalayer.interfaces;

import java.util.Set;

import nl.scalda.pasimo.model.employeemanagement.Student;

public interface IDAOStudent {
	public void create(Student s);
	
	public Set<Student> readAll();
}
