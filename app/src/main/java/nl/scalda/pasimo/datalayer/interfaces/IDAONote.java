package nl.scalda.pasimo.datalayer.interfaces;

import nl.scalda.pasimo.model.employeemanagement.Note;

public interface IDAONote {

	
	public Note create(Note note);
	
	public Note read(int id);
	
	public Note update(Note note);
	
	public void delete(Note note);
	
}
