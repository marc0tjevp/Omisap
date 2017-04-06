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
    	
    	System.out.println("Lul!");
    	
    	Teacher tc = new Teacher(124, "k@k.com", 215950, "sibgadhfasfd", "van", "klaas", 1999, 9, 15);
    	CoachGroup cg = new CoachGroup(0, "12", tc);
    	CoachGroup cg1 = new CoachGroup(1, "12", tc);
    	CoachGroup cg2 = new CoachGroup(2, "12", tc);
    	CoachGroup cg3 = new CoachGroup(3, "12", tc);
    	CoachGroup cg4 = new CoachGroup(4, "12", tc);
    	
    	EducationTeam edu = new EducationTeam(1, "12");
    	EducationTeam edu1 = new EducationTeam(2, "13");
    	EducationTeam edu2 = new EducationTeam(3, "14");
    	EducationTeam edu3 = new EducationTeam(4, "15");
    	EducationTeam edu4 = new EducationTeam(5, "16");
    	
    	EducationTeamService.getInstance().edu.add(edu);
    	EducationTeamService.getInstance().edu.add(edu1);
    	EducationTeamService.getInstance().edu.add(edu2);
    	EducationTeamService.getInstance().edu.add(edu3);
    	EducationTeamService.getInstance().edu.add(edu4);
    	
    	
    	CoachGroupService.getInstance().create(cg, edu);
    	CoachGroupService.getInstance().create(cg1, edu);
    	CoachGroupService.getInstance().create(cg2, edu);
    	CoachGroupService.getInstance().create(cg3, edu);
    	CoachGroupService.getInstance().create(cg4, edu);
    	
    
    	
     	System.out.println(CoachGroupService.getInstance().readCoachGroup(cg.getId()));
     	System.out.println((CoachGroupService.getInstance().getEducationTeam(cg1)));
    	System.out.println(CoachGroupService.getInstance().readAll());
    
    	CoachGroupService.getInstance().delete(cg);
    }

}
