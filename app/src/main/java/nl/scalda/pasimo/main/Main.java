/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import java.sql.Date;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAONote;
import nl.scalda.pasimo.datalayer.testdao.TestDAONote;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.NoteService;
import nl.scalda.pasimo.service.TeacherService;


/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {
    	TreeSet<Note> noteList = new TreeSet<>();
    	Student s = new Student(3, 1, "1", "1", "1", "1", 1, 1,noteList, 1, 1);
    		Teacher teacher = new Teacher("GG", 666);
    
Note n = new Note();
	
		

		Note n1 = NoteService.getInstance().readByID(2);
		n1.setOvNumber(1251251);
    	teacher.editNote(2);
    		
    }	

}
