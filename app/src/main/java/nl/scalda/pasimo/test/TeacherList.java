package nl.scalda.pasimo.test;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeeManagement.Teacher;
import nl.scalda.pasimo.service.Service;
import nl.scalda.pasimo.service.TeacherService;

public class TeacherList extends TreeSet<Teacher> {

	private static TeacherList instance;
	private TreeSet<Teacher> teachers = new TreeSet<>();
	
	private TeacherList() {}
	
	public void addTeacher(Teacher t){
		teachers.add(t);
	}
	
	public void removeTeacher(Teacher t) {
		teachers.remove(t);
	}
	
    public TreeSet<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(TreeSet<Teacher> teachers) {
		this.teachers = teachers;
	}

	public static TeacherList getInstance() {
        if (instance == null) {
            instance = new TeacherList();
        }
        return instance;
    }
}
