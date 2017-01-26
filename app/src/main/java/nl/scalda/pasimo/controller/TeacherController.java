package nl.scalda.pasimo.controller;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.Cluster;
import nl.scalda.pasimo.model.EducationTeam;
import nl.scalda.pasimo.model.Teacher;
import nl.scalda.pasimo.service.Service;

public class TeacherController extends ActionSupport{
	
	public Teacher teacher = new Teacher();
	public String teamAbbreviation;
	public TreeSet<Teacher> teachers = new TreeSet<>();
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	public String execute(){
		return SUCCESS;
	}
	
	public String addTeacher() {
		EducationTeam team = getEducationTeamByID(teamAbbreviation);
		teacher.setAbbreviation();
		System.out.println(teacher);
		
		team.addTeacher(teacher);
		
//		teachers.add(teacher);
		return SUCCESS;
	}

	public String readTeacher() {
		Teacher t = new Teacher(123456, "email@myemaildomain.com", 654321789, "henk", "de", "alien", 1965, 7, 23);
		Teacher t1 = new Teacher(876543, "anotherEmail@myemaildomain.com", 635685473, "klaas", "de", "boer", 1932, 11, 1);
		teachers.add(t);
		teachers.add(t1);
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
		for (EducationTeam ct : Cluster.getInstance().getEducationTeams()) {
			for(Teacher cte : ct.getTeachers()){
				teachers.add(cte); 
			}
		}
		return teachers;
	}
	
	public EducationTeam getEducationTeamByID(String abbreviation){
		for (EducationTeam ct : Cluster.getInstance().getEducationTeams()) {
			for(Teacher cte : ct.getTeachers()){
				if(cte.getAbbreviation().equals(abbreviation)){
					return ct;
				}
			}
		}
		return null;
	}

	public void setTeachers(TreeSet<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public String getTeamAbbreviation() {
		return teamAbbreviation;
	}

	public void setTeamAbbreviation(String teamAbbreviation) {
		this.teamAbbreviation = teamAbbreviation;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

}
