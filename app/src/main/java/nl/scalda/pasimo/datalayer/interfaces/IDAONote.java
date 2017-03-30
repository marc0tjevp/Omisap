package nl.scalda.pasimo.datalayer.interfaces;

import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

public interface IDAONote {

	
	public Note create(Note note, Student s);
	
	public Note read(int id);
	
	public Note update(Note note);
	
	public void delete(Note note);
	
}
