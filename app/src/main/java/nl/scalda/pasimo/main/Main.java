/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.EducationTeamService;

/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {
    	
    	WorkingDay w = new WorkingDay("maandag");
    
    	WorkBlock workblock = new WorkBlock(2, "9:30", "10:10");
    	
//    	w.addWorkBlock(workblock);
    	

    	
    	w.deleteWorkBlock(workblock);
    	
    	
    }

}
