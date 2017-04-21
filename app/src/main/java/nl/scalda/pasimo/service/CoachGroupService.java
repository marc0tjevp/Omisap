/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.service;

import java.util.Objects;
import java.util.TreeSet;

import javassist.compiler.ast.Pair;
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

/**
 *
 * @author Collin and ismet
 */
public class CoachGroupService {

    private static CoachGroupService instance = null;
    
    /**
     * Sends CoachGroup to EducationTeam to create
     * @param cg
     * @param edu
     */
    public void create(CoachGroup cg, EducationTeam edu) {//teacher
    	edu.addCoachGroup(cg);
    }
    
    /**
     * Reads a CoachGroup by id
     * @param id
     * @return cg
     */
    public CoachGroup readCoachGroup(String name) {
    	for(EducationTeam edu: EducationTeamService.getInstance().getEducationTeams(0) ){
    		  for(CoachGroup cg :edu.getCoachGroups()){
    			  if(cg.getName().equals(name)){
    				  return cg;
    		  }
    		}
    		
    	}
    	return null;
    }
    
    /**
     * Get EducationTeam from a CoachGroup
     * @param cg
     * @return edu
     */
    public EducationTeam getEducationTeam(CoachGroup cg) {
    	for(EducationTeam edu: EducationTeamService.getInstance().getEducationTeams(0) ){
    			  if(edu.getCoachGroups().contains(cg)){
    				  return edu;
    		  }
    	}
    	return null;
    }
    
    /**
     * Reads all CoachGroups
     * @return TreeSet<CoachGroup>
     */
    public TreeSet<CoachGroup> readAll() {
    	TreeSet<CoachGroup> AllCoachGroups = new TreeSet<>();
    	for(EducationTeam edu: EducationTeamService.getInstance().getEducationTeams(0) ){
    		AllCoachGroups.addAll(edu.getCoachGroups());
    		}
    	return AllCoachGroups;
    }

    /**
     * updates a CoachGroup
     * @param cg
     */
    public void update(CoachGroup cg) {
    	cg.updateCoachGroup();
        
    }

    /**
     * Sends CoachGroup to EducationTeam to delete
     * @param cg
     * @param edu
     */
    public void delete(CoachGroup cg) {
    	for(EducationTeam edu: EducationTeamService.getInstance().getEducationTeams(0) ){
    		if(edu.getCoachGroups().contains(cg)){
    		  edu.deleteCoachGroup(cg);
    		  }
    		}
    }

    public static CoachGroupService getInstance() {
        if (instance == null) {
            instance = new CoachGroupService();
        }
        return instance;
    }
}
