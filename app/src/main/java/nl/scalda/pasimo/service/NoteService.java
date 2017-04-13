package nl.scalda.pasimo.service;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class NoteService {

    private static NoteService instance = null;

    private NoteService() {

    }

    public Note create(Note note, Student s) {
    
    	return DAOFactory.getTheFactory().getDAONote().create(note);
    }

    public Note update(Note note) {	
        return DAOFactory.getTheFactory().getDAONote().update(note);
    }

    public void delete(int id) {
        DAOFactory.getTheFactory().getDAONote().delete(id);
    }
    
    public Note readByID(int id){
    	DAOFactory n = DAOFactory.getTheFactory();
    	return DAOFactory.getTheFactory().getDAONote().read(id);
    }
    
    public static NoteService getInstance() {
        if (instance == null) {
            instance = new NoteService();
        }
        return instance;
    }
}
