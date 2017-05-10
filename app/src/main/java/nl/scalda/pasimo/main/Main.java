<<<<<<< HEAD
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

	}
=======
/**
 * 
 */
package nl.scalda.pasimo.main;

/**
 * @author Bram van Huele
 * Pasimo
 * 12 apr. 2017
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

>>>>>>> cb74bd81699c256a6f60371c10c38929fd19e0bb
}
