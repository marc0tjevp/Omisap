package nl.scalda.pasimo.model.EmployeeManagement;

import java.util.TreeSet;

public class LessonGroup {

	int id;
	String name;
	TreeSet<Student> students;

	public LessonGroup() {

	}

	public LessonGroup(int id, String name, TreeSet<Student> students) {
		this.id = id;
		this.name = name;
		this.students = students;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeSet<Student> getStudents() {
		return this.students;
	}

	public void setStudents(TreeSet<Student> students) {
		this.students = students;
	}

}
