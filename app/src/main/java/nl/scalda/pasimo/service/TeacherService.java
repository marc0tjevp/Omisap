package nl.scalda.pasimo.service;

import java.util.ArrayList;
import java.util.TreeSet;

import com.mysql.fabric.xmlrpc.base.Array;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.MySQLDAOFactory;
import nl.scalda.pasimo.model.employeeManagement.EducationTeam;
import nl.scalda.pasimo.model.employeeManagement.Teacher;

public class TeacherService {

	private static TeacherService instance;

	private TeacherService() {
	}

	public void create(Teacher t, EducationTeam team) {
		team.addTeacher(t);
		
	}

//	public void addTeacherToEducationTeam(Teacher t, EducationTeam team) {
//		team.addTeacher(t);
//	}

//	public Teacher readByID(int id) {
//		for (EducationTeam ct : Cluster.getInstance().getEducationTeams()) {
//			for(Teacher cte : ct.getTeachers()){
//				if(cte.getEmployeeNumber() == id){
//					return cte;
//				}
//			}
//		}
//		return null;
//	}

	public void update(Teacher t) {
//		EducationTeam tmpTeam = getTeamForTeacher(t);
//		DAOFactory.getTheFactory().getDAOTeacher().update(t, tmpTeam);
	}

//	public EducationTeam getTeamForTeacher(Teacher t){
//		for (EducationTeam ct : Cluster.getInstance().getEducationTeams()) {
//			for(Teacher cte : ct.getTeachers()){
//				if(cte.getAbbreviation().equals(t.getAbbreviation())){
//					return ct;
//				}
//			}
//		}
//		return null;
//	}

	public void delete(Teacher t, EducationTeam team) {

	}

	public TreeSet<Teacher> readAllForTeam(EducationTeam t) {
		return null;
	}

	public static TeacherService getInstance() {
		if (instance == null) {
			instance = new TeacherService();
		}
		return instance;
	}

}
