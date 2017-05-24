/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.controller.presenceregistration;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;
import nl.scalda.pasimo.service.EducationTeamService;
import nl.scalda.pasimo.service.TeacherService;

/**
 *
 * @author hunteroooox
 */
public class PresenceController extends ActionSupport {
	
//	private static final long serialVersionUID = 1L;
//
//	public TreeSet<Teacher> teacher = new TreeSet<>();
//	public TreeSet<Teacher> checkedInTeacher = new TreeSet<>();
//	public TreeSet<Teacher> checkedOutTeacher = new TreeSet<>();
//	public TreeSet<EducationTeam> teams = new TreeSet<>();
//	public String id;
//	
//	public String loadCheckedInTeachers(){
//		getCheckedInTeacher();
//		return SUCCESS;
//	}
//	
//	
//	
//	public TreeSet<EducationTeam> getTeams() {
//		if(teams.isEmpty()){
//			teams.addAll(EducationTeamService.getInstance().getEducationTeams());
//		}
//		return teams;
//	}
//
//
//
//	public void setTeams(TreeSet<EducationTeam> teams) {
//		this.teams = teams;
//	}
//
//
//
//	public TreeSet<Teacher> getTeacher() {
//		if(teacher.isEmpty()){
//			for(EducationTeam team : EducationTeamService.getInstance().getEducationTeams()){
//				if(team.getId() == Integer.parseInt(id)){
//					teacher.addAll(team.getTeachers());
//				}
//			}
//		}
//		return teacher;
//	}
//
//	public TreeSet<Teacher> getCheckedInTeacher() {
//		if(checkedInTeacher.isEmpty()){
//			TreeSet<CheckIn> checkIn = TeacherService.getInstance().readAllCheckedIn();
//			for(Teacher t : getTeacher()){
//				for(CheckIn c : checkIn){
//					if(c.getEmail().equals(t.getEmail())){
//						if(c.getIsCheckIn()){
//							checkedInTeacher.add(t);
//						}
//					}
//				}
//			}
//
//		}
//		return checkedInTeacher;
//	}
//	
//	public TreeSet<Teacher> getCheckedOutTeacher() {
//		if(checkedOutTeacher.isEmpty()){
//			for(Teacher t : teacher){
//				if(!( getCheckedInTeacher().contains(t))){
//					checkedOutTeacher.add(t);
//				}
//			}
//		}
//		return checkedOutTeacher;
//	}
//
//	public void setCheckedOutTeacher(TreeSet<Teacher> checkedOutTeacher) {
//		this.checkedOutTeacher = checkedOutTeacher;
//	}
//
//	
//
//	public void setCheckedInTeacher(TreeSet<Teacher> checkedInTeacher) {
//		this.checkedInTeacher = checkedInTeacher;
//	}
//
//	public void setTeacher(TreeSet<Teacher> teacher) {
//		this.teacher = teacher;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//
//
//	public String execute() {
//        return SUCCESS;
//    }

}
