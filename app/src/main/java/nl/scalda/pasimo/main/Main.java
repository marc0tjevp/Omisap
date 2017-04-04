/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import java.sql.Date;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAONote;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {
    	TreeSet<Note> noteList = new TreeSet<>();
    	Student s = new Student(3, 1, "1", "1", "1", "1", 1, 1,noteList, 1, 1);
    		Teacher teacher = new Teacher("GG", 666);
    		Date creationDate = new Date(666);
    		Date lastEdit = new Date(555);
    		Note note = new Note();
    		note.setTitle("asdf");
    		note.setMessage("ASDFSDAFSADFASDFSADFSADFASD");
    		note.setMadeBy(teacher);
    		note.setCreationDate(creationDate);
    		note.setLastEdit(lastEdit);
    		note.setStudent(s);

    		
    		
    		System.out.println(note.getId());
    		
    		
    		Note note1 = new Note();
    		note1.setTitle("asdf");
    		note1.setMessage("ASDFSDAFSADFASDFSADFSADFASD");
    		note1.setMadeBy(teacher);
    		note1.setCreationDate(creationDate);
    		note1.setLastEdit(lastEdit);
    		note1.setStudent(s);
    		
    		System.out.println(note1.getId());
    		
    		Note note2 = new Note();
    		note2.setTitle("asasdf");
    		note2.setMessage("ASDFSDadAFSADFASDFSADFSADFASD");
    		note2.setMadeBy(teacher);
    		note2.setCreationDate(creationDate);
    		note2.setLastEdit(lastEdit);
    		note2.setStudent(s);
    		
    		System.out.println(note2.getId());
    	
    		MYSQLDAONote.getInstance().read(1);
    		
    }

}
