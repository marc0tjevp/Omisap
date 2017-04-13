/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.NoteService;

/**
 *
 * @author jeroe
 */
public class Main {

	public static void main(String args[]) {
		TreeSet<Note> noteList = new TreeSet<>();
		Student s = new Student(3, 1, "1", "1", "1", "1", 1, 1, noteList, 1, 1);
		Teacher teacher = new Teacher("GG", 666);
		teacher.deleteAllNotes();
//		Note n1 = NoteService.getInstance().readByID(2);
//		n1.setMessage("KEVIN'S KAPSTER");
//		teacher.editNote(n1);


	}

}
