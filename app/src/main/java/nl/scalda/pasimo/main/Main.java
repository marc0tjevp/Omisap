/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;


import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.EducationTeamService;


/**
 *
 * @author Pasimo
 */
public class Main {

    public static void main(String args[]) {
    	
    	//DAOFactory.setTheFactory(DAOFactory.getTheFactory());
    	DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
    	Teacher teacher = new Teacher("han", 215950, "im@student.nl");	
    	LessonGroup lg = new LessonGroup(123, "ICO41A");
    	CoachGroup cg = new CoachGroup("ICO", teacher);
    	EducationTeam ed = new EducationTeam("edu", "education", 135); 
		
    
    	cg.setCoach(teacher);
    	EducationTeamService.getInstance().getEducationTeams().add(ed);
    	CoachGroupService.getInstance().create(cg, ed);
    
    	
    	
    	

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	WorkingDay w = new WorkingDay("maandag");
//    	WorkBlock workblock = new WorkBlock(2, "9:30", "10:10");    	
//    	w.addWorkBlock(workblock);
//    	w.deleteWorkBlock(workblock);
    }

}
