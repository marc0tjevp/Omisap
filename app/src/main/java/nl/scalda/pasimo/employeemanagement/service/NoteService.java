package nl.scalda.pasimo.employeemanagement.service;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.employeemanagement.interfaces.IDAONote;
import nl.scalda.pasimo.employeemanagement.model.Note;

public class NoteService implements IDAONote{

	private static NoteService instance = null;
	
	private IDAONote noteDAO;
	
	
	private NoteService() {
		this.noteDAO = DAOFactory.getTheFactory().getDAONote();
	}

	@Override
	public Note create(Note note) {
		return noteDAO.create(note);
	}

	@Override
	public Note read(int id) {
		return noteDAO.read(id);
	}

	@Override
	public Note update(Note note) {
		return noteDAO.update(note);
	}

	@Override
	public void delete(Note note) {
		noteDAO.delete(note);
		
	}
	
	public static NoteService getInstance(){
		if(instance == null){
			instance = new NoteService();
		}
		return instance;
	}
}
