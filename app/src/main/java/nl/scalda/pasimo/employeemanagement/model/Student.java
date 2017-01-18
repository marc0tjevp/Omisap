package nl.scalda.pasimo.employeemanagement.model;

import java.util.TreeSet;

public class Student {

	private String name;
	private TreeSet<Note> noteList;
	
	public Student(String name) {
		this.name = name;
		noteList = new TreeSet<>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public TreeSet<Note> getNoteList(){
		return this.noteList;
	}
	
}
