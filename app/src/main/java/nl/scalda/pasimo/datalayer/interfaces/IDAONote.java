package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.Note;

public interface IDAONote {

	
	public void create(Note note);
	
	public Note read(int id);
	
	public Note update(Note note);
	
	public void delete(int id);
	
	public void deleteAll();
	
	public TreeSet<Note> readAll();

	
}
