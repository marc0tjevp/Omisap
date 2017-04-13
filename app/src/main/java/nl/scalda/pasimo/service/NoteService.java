package nl.scalda.pasimo.service;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class NoteService {

    private static NoteService instance = null;

    private NoteService() {

    }

    public Note create(Note note, Student s) {
    
    	return DAOFactory.getTheFactory().getDAONote().create(note);
    }

    public Note update(int id) {
    	System.out.println("readByID voor de edit");
    	Note note = NoteService.getInstance().readByID(id);
    	System.out.println("update na de read by id");
        return DAOFactory.getTheFactory().getDAONote().update(note);
    }

    public void delete(int id) {
        DAOFactory.getTheFactory().getDAONote().delete(id);
    }
    
    public Note readByID(int id){
    	System.out.println("readById");
    	return DAOFactory.getTheFactory().getDAONote().read(id);
    }
    
    public static NoteService getInstance() {
        if (instance == null) {
            instance = new NoteService();
        }
        return instance;
    }
}
