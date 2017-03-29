/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.service;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

/**
 *
 * @author jeroe
 */
public class CoachGroupService {

    private static CoachGroupService instance = null;
    
    public void create(CoachGroup coachGroup) {//teacher
    	coachGroup.addCoachGroup();
    	
    }

    public CoachGroup read(CoachGroup coachGroup) {
    	return null;
    }
    
    public TreeSet<CoachGroup> readAll(CoachGroup coachGroup) {
    	return null;
    }

    public void update(CoachGroup coachGroup) {
    	coachGroup.updateCoachGroup();
        //DAOFactory.getTheFactory().getDAOCoachGroup().update(coachGroup);
    }

    public void delete(CoachGroup coachGroup) {
    	coachGroup.deleteCoachGroup();
        //DAOFactory.getTheFactory().getDAOCoachGroup().delete(coachGroup);
    }

    public static CoachGroupService getInstance() {
        if (instance == null) {
            instance = new CoachGroupService();
        }
        return instance;
    }
}
