package nl.scalda.pasimo.model.employeemanagement;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class Student extends Person {

    private int ovNumber;
    private TreeSet<Note> noteList;
    private GregorianCalendar cohort;
    
    public Student(){
        
    }

    public Student(TreeSet<Note> noteList) {
        this.noteList = noteList;
    }

    public Student(TreeSet<Note> noteList, String email, int cardID, String firstName, String insertion, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
        this.noteList = noteList;
    }
    
    

    public Student(String name) {

        noteList = new TreeSet<>();
    }

    public TreeSet<Note> getNoteList() {
        return this.noteList;
    }

}
