package nl.scalda.pasimo.service;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.model.employeeManagement.Note;

public class NoteService{

	private static NoteService instance = null;
	
	private NoteService() {

	}
	
	public Note create(Note note){
		return DAOFactory.getTheFactory().getDAONote().create(note);
	}
	
	public Note update(Note note){
		return DAOFactory.getTheFactory().getDAONote().update(note);
	}
	
	
	public static NoteService getInstance(){
		if(instance == null){
			instance = new NoteService();
		}
		return instance;
	}
}