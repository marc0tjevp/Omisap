package nl.scalda.pasimo.interfaces;

import nl.scalda.pasimo.model.employeeManagement.Note;

public interface IDAONote {

	
	public Note create(Note note);
	
	public Note read(int id);
	
	public Note update(Note note);
	
	public void delete(Note note);
	
}
