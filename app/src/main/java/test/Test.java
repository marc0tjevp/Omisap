package test;

import nl.scalda.pasimo.employeemanagement.model.Note;
import nl.scalda.pasimo.employeemanagement.model.Student;
import nl.scalda.pasimo.employeemanagement.model.Teacher;

public class Test {

	public static void main(String[] args) {
		
		Student stu1 = new Student("Jos Rijborz");
		Teacher tea1 = new Teacher("Bram");
		stu1.getNoteList().add(new Note("TestNote", "testing the notes", tea1));
		
		for (Note note : stu1.getNoteList()) {
			System.out.println(note.getTitle());
			System.out.println(note.getMessage());
			System.out.println(note.getMadeBy().getName());
			System.out.println();
		}
			
	}

}
