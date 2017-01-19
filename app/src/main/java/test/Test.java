package test;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOFactory;
import nl.scalda.pasimo.employeemanagement.model.Note;
import nl.scalda.pasimo.employeemanagement.model.Student;
import nl.scalda.pasimo.employeemanagement.model.Teacher;

public class Test {

	public static void main(String[] args) {
		
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		
		Student stu1 = new Student("Jos Rijborz");
		Teacher tea1 = new Teacher("Bram");
		
		Note n1 = new Note("TestTitel", "Test note", tea1);
		Note n2 = new Note("TestNote", "Test notities", tea1);
		
		stu1.getNoteList().add(n1);
		stu1.getNoteList().add(n2);
		
		for (Note note : stu1.getNoteList()) {
			System.out.println(note.getTitle());
			System.out.println(note.getMessage());
			System.out.println(note.getMadeBy().getName());
			System.out.println();
		}
			
		stu1.getNoteList().remove(n1);
		
		for (Note note : stu1.getNoteList()) {
			System.out.println(note.getTitle());
			System.out.println(note.getMessage());
			System.out.println(note.getMadeBy().getName());
			System.out.println();
		}
		
	}

}
