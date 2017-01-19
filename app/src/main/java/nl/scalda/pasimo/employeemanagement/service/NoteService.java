package nl.scalda.pasimo.employeemanagement.service;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.employeemanagement.interfaces.IDAONote;
import nl.scalda.pasimo.employeemanagement.model.Note;

public class NoteService implements IDAONote{

	private static NoteService instance = null;
	
	private NoteService() {

	}

	@Override
	public Note create(Note note) {
		return DAOFactory.getTheFactory().getDAONote().create(note);
	}

	@Override
	public Note read(int id) {
		return DAOFactory.getTheFactory().getDAONote().read(id);
	}

	@Override
	public Note update(Note note) {
		return DAOFactory.getTheFactory().getDAONote().update(note);
	}

	@Override
	public void delete(Note note) {
		DAOFactory.getTheFactory().getDAONote().delete(note);
		
	}
	
	public static NoteService getInstance(){
		if(instance == null){
			instance = new NoteService();
		}
		return instance;
	}
}
