package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOCoachGroup;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOTeacher;
import nl.scalda.pasimo.datalayer.testdao.TestDAOEducationTeam;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.EducationTeamService;

public class Main {

	public static void main(String args[]) {

		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		Teacher teacher = new Teacher("han", 215950, "im@student.nl");
		CoachGroup cg = new CoachGroup("abc", teacher);
		EducationTeam ed = new EducationTeam("appy", "ICOAO", 1);
		
		
		//ed.addCoachGroup(cg);
		//ed.loadCoachGroups();
		//System.out.println(ed.getCoachGroups());
		System.out.println(MYSQLDAOTeacher.getInstance().readByEmployeeNumber(215950));
	
	 //   EducationTeamService.getInstance().getEducationTeams();
		//TestDAOEducationTeam.getInstance().create(ed);
		
//		System.out.println(DAOFactory.getTheFactory().getDAOCoachGroup().readAllBYTeam(ed));
//		Delete
//		CoachGroupService.getInstance().delete(cg);

// 		ReadbyTeam
//		System.out.println(MYSQLDAOCoachGroup.getInstance().readAllBYTeam(ed));
		
//		CREATE
//		cg.setCoach(teacher);
//		EducationTeamService.getInstance().getEducationTeams().add(ed);
//		CoachGroupService.getInstance().create(cg, ed);

	}
}
