package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class TestDAONote implements IDAONote {

	private static TestDAONote instance = null;
	
	private TreeSet<Note> noteList;
	
	public static TestDAONote getInstance(){
		if(instance == null){
			instance = new TestDAONote();
		}
		return instance;
	}
	
	private TestDAONote() {
		Teacher tea1 = new Teacher();
		Student s = new Student("test");
                tea1.setFirstName("Bram");
		noteList = new TreeSet<Note>();
		Note note1 = new Note("Vertraging bus", "Lijn 660 had vertraging van 30 minuten",s, tea1);
		Note note2 = new Note("Vertraging boot", "Boot had vertraging van 30 minuten",s, tea1);
		Note note3 = new Note("Vertraging vliegtuig", "Vliegtuig had vertraging van 30 minuten",s, tea1);
		
		noteList.add(note1);
		noteList.add(note2);
		noteList.add(note3);
	}
	
	@Override
	public Note create(Note note) {
		int id = this.noteList.size();
		note.setId(id);
		if(this.noteList.add(note)){
			return note;
		}else{
			return this.update(note);
		}
		
	}

	@Override
	public Note read(int id) {
		for (Note note : noteList) {
			if(note.getId() == id){
				return note;
			}
		}
		return null;
	}

	@Override
	public Note update(Note note) {
		for (Note n : noteList) {
			if(note.compareTo(n) == 0){
				n.setTitle(note.getTitle());
				n.setMessage(note.getMessage());
				n.setLastEdit(note.getLastEdit());
				return n;
			}
		}
		return null;
	}

	@Override
	public void delete(int id) {
		for(Note n : noteList){
			if( id == n.getId()){
				noteList.remove(n);
			}
		}
	}

	@Override
	public void deleteAll() {
		noteList.clear();
		
	}

	@Override
	public TreeSet<Note> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
