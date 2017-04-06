/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {

    	WorkingDay w = new WorkingDay("Maandag");
    	WorkBlock workblock = new WorkBlock(0,"", "");
    	
    	
    	workblock.setId(2);
    	workblock.setStartTime("8:35");
    	workblock.setEndTime("12:05");
    	w.addWorkBlock(workblock);
    	
    	
    	
    	System.out.println(w);
    }

}
