
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Team;

//import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
//import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
//import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
//import nl.scalda.pasimo.model.employeemanagement.Teacher;


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

    	EducationTeam e = new EducationTeam("O","O");

    	Team t = new Team("","");


        
//    	t.addEducationTeam(e);
//
//    	e.setId(999);
//    	t.removeEducationTeam(e);
//
//    	e.setId(999);
//    	e.setName("POEP");
//    	e.setAbbreviation("P");
//    	t.updateEducationTeam(e);
    	
    	
    	DAOFactory.getTheFactory().getDAOEducationTeam().readAll();

	}

}
