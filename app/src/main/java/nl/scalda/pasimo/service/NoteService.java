package nl.scalda.pasimo.service;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class NoteService {

    private static NoteService instance = null;

    private NoteService() {

    }

    public Note create(Note note, Student s) {
        return DAOFactory.getTheFactory().getDAONote().create(note, s);
    }

    public Note update(Note note, Student s) {
        return DAOFactory.getTheFactory().getDAONote().update(note, s);
    }

    public static NoteService getInstance() {
        if (instance == null) {
            instance = new NoteService();
        }
        return instance;
    }
}
