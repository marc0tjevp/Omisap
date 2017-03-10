/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.model.timeregistration;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;

/**
 *
 * @author Diederik
 */
public class WorkingDay implements Comparable<WorkingDay> {

	public String name;

	private Set<WorkBlock> workBlocks;

	public WorkingDay(String name) {
		this(name, new TreeSet<WorkBlock>());

	}

	public WorkingDay(String name, Set<WorkBlock> workBlocks) {
		this.name = name;
		this.workBlocks = workBlocks;
	}

	// adds an workblock to a workingday

	public void addWorkBlock(WorkBlock workblock) {
		this.workBlocks.add(workblock);
	}

	// deletes an workblock

	public void deleteWorkBlock(WorkBlock workblock) {
		this.workBlocks.remove(workblock);
	}

	// updates an workblock

	public void updateWorkBlock(WorkBlock workblock) {
		for (WorkBlock wo : this.workBlocks) {
			if (wo.startTime.equals(workblock.getStartTime())) {
				wo.setStartTime(workblock.getStartTime());
				wo.setEndTime(workblock.getEndTime());

			}
		}

	}

	public String wieIsErOpTijd() {
		return "Weet ik niet maar in iederig geval Diederik wel";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<WorkBlock> getWorkBlocks() {
		return workBlocks;
	}

	public void setWorkBlocks(Set<WorkBlock> workBlocks) {
		this.workBlocks = workBlocks;
	}

	@Override
	public String toString() {
        return "WorkingDay{" +
        		"name='" + name + '\'' +
        		 "workBlocks='" + workBlocks + '\'' +
                '}';
    }

	@Override
	public int compareTo(WorkingDay w) {
		return this.name.compareTo(w.getName());
	}

}
