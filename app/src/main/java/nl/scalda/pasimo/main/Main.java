/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.EducationTeamService;

/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {
    	Teacher tc = new Teacher(124, "k@k.com", 215950, "sibgadhfasfd", "van", "klaas", 1999, 9, 15);
    	CoachGroup cg = new CoachGroup(0, "12", tc);
    	EducationTeam edu = new EducationTeam(1, "12");
    	EducationTeamService.getInstance().edu.add(edu);
    	
    	
    	CoachGroupService.getInstance().create(cg, edu);
    	
     cg.setName("12");
     CoachGroupService.getInstance().update(cg);
    	

    
    	CoachGroupService.getInstance().delete(cg);
    }

}
