package nl.scalda.pasimo.employeemanagement.datalayer.test;

import java.util.TreeSet;

import nl.scalda.pasimo.employeemanagement.interfaces.IDAONote;
import nl.scalda.pasimo.employeemanagement.model.Note;

public class TestDAONote implements IDAONote {

	private static TestDAONote instance = null;
	
	private TreeSet<Note> noteList;
	
	
	private TestDAONote() {
		noteList = new TreeSet<Note>();
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
	public void delete(Note note) {
		noteList.remove(note);
	}
	
	public static TestDAONote getInstance(){
		if(instance == null){
			instance = new TestDAONote();
		}
		return instance;
	}

}
