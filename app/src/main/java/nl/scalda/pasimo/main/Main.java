package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.CoachGroupService;

public class Main {

	public static void main(String args[]) {

		// DAOFactory.setTheFactory(DAOFactory.getTheFactory());
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		Teacher teacher = new Teacher("han", 215950, "im@student.nl");
		CoachGroup cg = new CoachGroup("abc", teacher);
		EducationTeam ed = new EducationTeam("edu", "education", 1);
		ed.addCoachGroup(cg);

		DAOFactory.getTheFactory().getDAOCoachGroup().create(cg);
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
