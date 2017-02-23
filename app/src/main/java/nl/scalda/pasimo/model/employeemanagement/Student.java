package nl.scalda.pasimo.model.employeemanagement;

import java.util.Date;
import java.util.TreeSet;

public class Student extends Person {

    private String name;
    private TreeSet<Note> noteList;
    
    public Student(){
        
    }

    public Student(String name, TreeSet<Note> noteList) {
        this.name = name;
        this.noteList = noteList;
    }

    public Student(String name, TreeSet<Note> noteList, String email, int cardID, String firstName, String insertion, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
        this.name = name;
        this.noteList = noteList;
    }
    
    

    public Student(String name) {
        this.name = name;
        noteList = new TreeSet<>();
    }

    public String getName() {
        return this.name;
    }

    public TreeSet<Note> getNoteList() {
        return this.noteList;
    }

}
