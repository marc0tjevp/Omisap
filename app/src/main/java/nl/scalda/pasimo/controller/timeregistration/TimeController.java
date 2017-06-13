/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.controller.timeregistration;

import java.util.TreeSet;
import org.apache.struts2.components.Set;
import com.opensymphony.xwork2.ActionSupport;
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkWeek;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

public class TimeController extends ActionSupport {

	WorkWeek ww = new WorkWeek(1);

	// private TreeSet<WorkWeek> workweeks = new TreeSet<>();

	private TreeSet<WorkWeek> workweeks = DAOFactory.getTheFactory().getDAOWorkWeek().readAll();
	private TreeSet<WorkingDay> workingdays = DAOFactory.getTheFactory().getDAOWorkWeek().readAllWorkingDays();
	private TreeSet<WorkBlock> workblocks = DAOFactory.getTheFactory().getDAOWorkWeek().readAllWorkBlocks();

	public TreeSet<WorkingDay> getWorkingdays() {
		return workingdays;
	}

	public void setWorkingdays(TreeSet<WorkingDay> workingdays) {
		this.workingdays = workingdays;
	}

	public TreeSet<WorkBlock> getWorkblocks() {
		return workblocks;
	}

	public void setWorkblocks(TreeSet<WorkBlock> workblocks) {
		this.workblocks = workblocks;
	}

	public TreeSet<WorkWeek> getWorkweeks() {
		if (workweeks == null || workweeks.isEmpty())
			;

		workweeks = DAOFactory.getTheFactory().getDAOWorkWeek().readAll();
		System.out.println(workweeks);
		return workweeks;
	}

	public void setWorkweeks(TreeSet<WorkWeek> workweeks) {
		this.workweeks = workweeks;
	}

	WorkingDay w = new WorkingDay();
	private Object workblock;

	public String SSC() {
		return SUCCESS;
	}

	public String execute() {
		// getWorkweeks();
		// ww.getWorkingdays().size();
		// w.getWorkblocks().size();
		return SUCCESS;
	}

	public String createWorkBlock(WorkBlock workblock) {
		workblock.setId(0);
		workblock.setStart(null);
		workblock.setEnd(null);
		w.addWorkBlock(workblock);
		return SUCCESS;
	}

	public String updateWorkBlock(WorkBlock workblock) {
		// workblock.setId(0);
		// workblock.setStart(null);
		// workblock.setEnd(null);
		// w.updateWorkBlock(workblock);
		return SUCCESS;
	}

	public String removeWorkBlock(WorkBlock workblock) {
		// w.deleteWorkBlock(workblock);
		return SUCCESS;
	}

	public String readWorkBlock(WorkBlock workblock) {
		workblock.getworkblockId();
		workblock.getStart();
		workblock.getEnd();
		return SUCCESS;
	}

}