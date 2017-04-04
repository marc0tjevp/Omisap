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
=======
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.EducationTeamService;


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
    		note.setTitle("title");
    		note.setMessage("message");
    		note.setMadeBy(teacher);
    		note.setCreationDate(creationDate);
    		note.setLastEdit(lastEdit);
    		note.setStudent(s);
    		
    		Note note1 = new Note();
    		note1.setTitle("title");
    		note1.setMessage("message");
    		note1.setMadeBy(teacher);
    		note1.setCreationDate(creationDate);
    		note1.setLastEdit(lastEdit);
    		note1.setStudent(s);
    		
    		MYSQLDAONote.getInstance().create(note);
    		MYSQLDAONote.getInstance().create(note1);
  
    }

}
