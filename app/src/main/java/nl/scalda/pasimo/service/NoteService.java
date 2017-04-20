package nl.scalda.pasimo.service;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class NoteService {

    private static NoteService instance = null;

    private NoteService() {

    }

    public void create(Note note, Student s) {
    
    	DAOFactory.getTheFactory().getDAONote().create(note);
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
    
    public void deleteAll(){
    	DAOFactory.getTheFactory().getDAONote().deleteAll();
    }
    public TreeSet<Note> readAll(){
    	return DAOFactory.getTheFactory().getDAONote().readAll();
    }
    
    public static NoteService getInstance() {
        if (instance == null) {
            instance = new NoteService();
        }
        return instance;
    }
}
