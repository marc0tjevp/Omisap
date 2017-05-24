package nl.scalda.pasimo.main;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOCoachGroup;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOTeacher;
import nl.scalda.pasimo.datalayer.testdao.TestDAOCheckIn;
import nl.scalda.pasimo.datalayer.testdao.TestDAOEducationTeam;
import nl.scalda.pasimo.datalayer.testdao.TestDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.EducationTeamService;

public class Main {

	public static void main(String args[]) {

		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		Teacher teacher = new Teacher("han", 215950, "im@student.nl");
		CoachGroup cg = new CoachGroup("abc", teacher);
		CoachGroup bla = new CoachGroup("abc");
		EducationTeam ed = new EducationTeam("appy", "ICOAO", 1);
		Teacher t = new Teacher("kslahfb", 82365, "habg@slakbg.nl");
		String oldname = cg.getName();		
		cg.setName("klaas");
		cg.setCoach(teacher);
		bla.load();
		System.out.println(bla);
//		CREATE
//		cg.setCoach(teacher);
//		EducationTeamService.getInstance().getEducationTeams().add(ed);
//		CoachGroupService.getInstance().create(cg, ed);
		
//		UPDATE
//		CoachGroupService.getInstance().update(cg, ed, oldname);
		
		
//		DELETE		
//		CoachGroupService.getInstance().delete(cg);

//		ReadByTeam
//		System.out.println(CoachGroupService.getInstance().readAll());
		CheckIn c = new CheckIn(0, "211543", 2017, 05, 13, 8, 30, 43);
		CheckIn d = new CheckIn(0, "211543", 2017, 05, 16, 9, 05, 11);
		TestDAOCheckIn.getInstance().add(c);
		TestDAOCheckIn.getInstance().add(d);
		
		TreeSet<Note>note = new TreeSet<>();
		Student s = new Student(215443, 2016, "student@email.com", "klaas", "", "vaak", "211543", 1998, note, 05, 12);	
		TestDAOStudent.getInstance().create(s);


	}
}
