/*
	+ * To change this license header, choose License Headers in Project Properties.
	+ * To change this template file, choose Tools | Templates
	+ * and open the template in the editor.
	Add a comment to this line
	+ */
package nl.scalda.pasimo.model.timeregistration;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;

/**
 * + * + * @author Diederik +
 */

public class WorkingDay implements Comparable<WorkingDay> {

	private String oldName;
	private String name;
	private Set<WorkBlock> workBlocks;

	public WorkingDay() {

	}

	public WorkingDay(String name) {
		this(name, new TreeSet<WorkBlock>());

	}

	public WorkingDay(String name, Set<WorkBlock> workBlocks) {
		this.name = name;
		this.workBlocks = workBlocks;
	} // adds
		// an
		// workblock
		// to
		// a
		// workingday

	public void addWorkBlock(WorkBlock workblock) {
		this.workBlocks.add(workblock);
//		DAOFactory.getTheFactory().getDAOWorkBlock().create(workblock);
	} // deletes
		// an
		// workblock

	public void deleteWorkBlock(WorkBlock workblock) {
		this.workBlocks.remove(workblock);

		DAOFactory.getTheFactory().getDAOWorkBlock().delete(workblock);
	} // updates
		// an
		// workblock

	public void updateWorkBlock(WorkBlock workblock) {
		workblock.setId(workblock.getId());
		workblock.setStart(workblock.getStart());
		workblock.setEnd(workblock.getEnd());

//		DAOFactory.getTheFactory().getDAOWorkBlock().update(workblock);

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

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	@Override
	public String toString() {
		return "WorkingDay{" + "name='" + name + '\'' + "workBlocks='" + workBlocks + '\'' + '}';
	}

	@Override
	public int compareTo(WorkingDay w) {
		return this.name.compareTo(w.getName());
	}
}