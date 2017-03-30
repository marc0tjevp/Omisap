/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.datalayer.mysqldao.*;

/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {
    		Teacher teacher = new Teacher("GG", 666);
    		Note note = new Note();
    		note.setTitle("title");
    		note.setMessage("message");
    		note.setMadeBy(teacher);

    		MYSQLDAONote.getInstance().create(note);
    		
    		
    		
    		
    
    }

}
