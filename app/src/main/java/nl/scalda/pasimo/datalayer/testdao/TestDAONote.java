package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class TestDAONote implements IDAONote {

    private static TestDAONote instance = null;
    
    private TreeSet<Teacher> teachers = new TreeSet<>();
    private TreeSet<Note> noteList = new TreeSet<>();
    
    private TestDAONote() {
//        Teacher tea1 = new Teacher();
//                tea1.setFirstName("Bram");
//        noteList = new TreeSet<Note>();
//        Note note1 = new Note("Vertraging bus", "Lijn 660 had vertraging van 30 minuten", tea1);
//        Note note2 = new Note("Vertraging boot", "Boot had vertraging van 30 minuten", tea1);
//        Note note3 = new Note("Vertraging vliegtuig", "Vliegtuig had vertraging van 30 minuten", tea1);
//        
//        noteList.add(note1);
//        noteList.add(note2);
//        noteList.add(note3);
    }
    
    @Override
    public Note create(Note note) {
        int id = this.noteList.size();
        note.setId(id);
        System.out.println(id);
        if(this.noteList.add(note)){
            return note;
        }else{
            return this.update(note);
        }
        
    }
    
    public Note noteAdd(Note note){
        
        noteList.add(note);
        return note;
        
        
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
    
    public TreeSet<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(TreeSet<Teacher> teachers) {
        this.teachers = teachers;
    }

    public TreeSet<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(TreeSet<Note> noteList) {
        this.noteList = noteList;
    }

    public static void setInstance(TestDAONote instance) {
        TestDAONote.instance = instance;
    }

    
    public static TestDAONote getInstance(){
        if(instance == null){
            instance = new TestDAONote();
        }
        return instance;
    }

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
