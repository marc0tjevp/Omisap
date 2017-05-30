/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.service;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;

/**
 *
 * @author Collin and ismet
 */
public class CoachGroupService {

	private static CoachGroupService instance = null;
	
	
	private CoachGroupService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Sends CoachGroup to EducationTeam to create
	 * 
	 * @param cg
	 * @param edu
	 */
	public void create(CoachGroup cg, EducationTeam edu) {// teacher
		edu.addCoachGroup(cg);
	}

	/**
	 * Reads a CoachGroup by id
	 * 
	 * @param id
	 * @return cg
	 */
	public CoachGroup readCoachGroup(String name) {
		for (EducationTeam edu : EducationTeamService.getInstance().getEducationTeams()) {
			for (CoachGroup cg : edu.getCoachGroups()) {
				if (cg.getName().equals(name)) {
					return cg;
				}
			}

		}
		return null;
	}

	/**
	 * Get EducationTeam from a CoachGroup
	 * 
	 * @param cg
	 * @return edu
	 */
	public EducationTeam getEducationTeam(CoachGroup cg) {
		for (EducationTeam edu : EducationTeamService.getInstance().getEducationTeams()) {
			
			if (edu.getCoachGroups().contains(cg)) {
				return edu;
			}
		}
		return null;
	}

	/**
	 * Reads all CoachGroups
	 * 
	 * @return TreeSet<CoachGroup>
	 */
	public TreeSet<CoachGroup> readAll() {
		TreeSet<CoachGroup> AllCoachGroups = new TreeSet<>();
		for (EducationTeam edu : EducationTeamService.getInstance().getEducationTeams()) {
			if(edu.getCoachGroups() != null){
			AllCoachGroups.addAll(edu.getCoachGroups());
			}
		}
		return AllCoachGroups;
	}

	/**
	 * updates a CoachGroup
	 * 
	 * String oldname so the DataBase can find the CoachGroup in the DAO so it can be updated
	 * @param String oldname
	 */
	public void update(CoachGroup cg ,String oldname) {
		this.getEducationTeam(cg).updateCoachGroup(cg, oldname);
		//cg.updateCoachGroup();

	}

	/**
	 * Sends CoachGroup to EducationTeam to delete
	 * 
	 * @param cg
	 */
	public void delete(CoachGroup cg) {
		for (EducationTeam edu : EducationTeamService.getInstance().getEducationTeams()) {
			if (edu.getCoachGroups().contains(cg)) {
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