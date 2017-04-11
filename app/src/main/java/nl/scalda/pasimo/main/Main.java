/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;


import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOEducationTeam;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Team;



/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {
    	
    	EducationTeam e = new EducationTeam("FRIKANDEL","O");

        Team t = new Team("", "");
        
        
//    	t.addEducationTeam(e);
    	

//    	e.setId(336);
//    	t.removeEducationTeam(e);

//    	e.setId(336);
//    	e.setName("POEP");
//    	e.setAbbreviation("P");
//    	t.updateEducationTeam(e);



    }

}
