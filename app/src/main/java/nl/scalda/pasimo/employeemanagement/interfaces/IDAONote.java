package nl.scalda.pasimo.employeemanagement.interfaces;

import nl.scalda.pasimo.employeemanagement.model.Note;

public interface IDAONote {

	
	public Note create(Note note);
	
	public Note read(int id);
	
	public Note update(Note note);
	
	public void delete(Note note);
	
}
