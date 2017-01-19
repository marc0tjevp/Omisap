package nl.scalda.pasimo.service;

import java.util.ArrayList;
import java.util.TreeSet;

import com.mysql.fabric.xmlrpc.base.Array;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.MySQLDAOFactory;
import nl.scalda.pasimo.model.Cluster;
import nl.scalda.pasimo.model.EducationTeam;
import nl.scalda.pasimo.model.Teacher;

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

	public Teacher readByAbbr(String abbr) {
		return null;
	}

	public void update(Teacher t, String oldAbbr) {
		for (EducationTeam ct : Cluster.getInstance().getEducationTeams()) {
			for(Teacher cte : ct.getTeachers()){
				System.out.println("Is dit het goede team van de teacher: " + ct);
			}
		}
	}

	public void delete(Teacher t, EducationTeam team) {

	}

	public void readAll() {

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
