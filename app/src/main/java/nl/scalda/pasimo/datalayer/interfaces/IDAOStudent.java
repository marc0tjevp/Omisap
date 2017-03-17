package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.Student;

public interface IDAOStudent {

	public void create(Student s);

	public void update(Student s);

	public void delete(Student s);

	public void readByOvNumber(int ov);

	public TreeSet<Student> readAll();
}
