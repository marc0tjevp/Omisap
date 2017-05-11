package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
<<<<<<< HEAD
<<<<<<< HEAD
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

/**
 * @author Bram van Huele
 * Pasimo
 * 12 apr. 2017
 */
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
		
//		READ
//		bla.load();
//		System.out.println(bla);

=======
=======
>>>>>>> 28b512722b24a672006cbdb282fbf336bfc03f70
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
<<<<<<< HEAD
>>>>>>> 6fddc386ba3dfe96be4afed04f2d3f2a14a9ecb7
=======

>>>>>>> 28b512722b24a672006cbdb282fbf336bfc03f70

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
}
