package nl.scalda.pasimo.controller;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.EducationTeam;
import nl.scalda.pasimo.model.Teacher;
import nl.scalda.pasimo.service.Service;

public class TeacherController extends ActionSupport{

	public Teacher teacher = new Teacher();
	public TreeSet<Teacher> teachers = new TreeSet<>();
	
	public String createTeacher() {
		Service.getInstance().getTeacherService().create(teacher, new EducationTeam("ONLY FOR TESTING PURPOSES"));
		return SUCCESS;
	}

	public String readTeacher() {
		return SUCCESS;
	}

	public String updateTeacher() {
		return SUCCESS;
	}

	public String deleteTeacher() {
		return SUCCESS;
	}
	
	public String updateTeacherEducationTeam(Teacher t, EducationTeam newTeam){
		return SUCCESS;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TreeSet<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(TreeSet<Teacher> teachers) {
		this.teachers = teachers;
	}

}
