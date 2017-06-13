package nl.scalda.pasimo.datalayer.testdao;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class TestDAOStudent implements IDAOStudent {
	private static TestDAOStudent instance;
	public TreeSet<Student> students;
	public TestDAOStudent(){
		students = new TreeSet<>();
	}
	
    public static TestDAOStudent getInstance() {
        if (instance == null) {
            instance = new TestDAOStudent();
        }
        return instance;
    }
    
	
	public void addStudentTestData(){
		
		TreeSet<Note>note = new TreeSet<>();
		Student s = new Student(1, 215443, 2016, "student@email.com", "Erin", "", "Boshart", "211543", 1998, note, 05, 12, "coachgroupname",  0);
		Student z = new Student(12, 215444, 2016, "student0@email.com", "Rien", "", "Hannewijk", "211544", 1998, note, 05, 12, "coachgroupname", 0);
		create(s);	
		create(z);
	}
    
	public Student getStudentByCardID(String cardID){
		
		Set<Student>studentList = readAll();	
		
		for(Student s : studentList){
			if(s.getCardID().equals(cardID)){
				return s;
			}
		} 
		return null;	
	}

	@Override
	public void create(Student s) {
		students.add(s);
		
	}
	
	@Override
	public Set<Student> readAll() {
		return students;
	}

	public TreeSet<Student> getStudents() {
		return students;
	}

	public void setStudents(TreeSet<Student> students) {
		this.students = students;
	}

}
