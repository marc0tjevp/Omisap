/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.CoachGroupService;

/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {
    	Teacher tc = new Teacher(124, "k@k.com", 215950, "sibgadhfasfd", "van", "klaas", 1999, 9, 15);
    	CoachGroup cg = new CoachGroup("123", tc);
    	cg.setId(125);
    	
    	CoachGroupService.getInstance().create(cg);
    	
    	
    	Teacher td = new Teacher(124, "k@k.nl", 215951, "sibgadhfadfsafasfd", "vsdfan", "klaasdfs", 192399, 92, 135);
    	cg.setCoach(td);
    	
    	
    	CoachGroupService.getInstance().update(cg);

    
    
    }

}
