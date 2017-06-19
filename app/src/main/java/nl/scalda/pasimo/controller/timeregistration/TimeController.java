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

	private WorkWeek ww;
	private WorkingDay w;
	private WorkBlock wb;

	
	private TreeSet<WorkBlock> workblocks = new TreeSet<>();
	private TreeSet<WorkingDay> workingdays = new TreeSet<>();
	private TreeSet<WorkWeek> workweeks = DAOFactory.getTheFactory().getDAOWorkWeek().readAll();

	public TreeSet<WorkWeek> getWorkweeks() {
		if (workweeks == null || workweeks.isEmpty()) {

			workweeks = DAOFactory.getTheFactory().getDAOWorkWeek().readAll();
		}

		return workweeks;
	}

	public void setWorkweeks(TreeSet<WorkWeek> workweeks) {
		this.workweeks = workweeks;
	}

	public WorkingDay getW() {
		return w;
	}

	public void setW(WorkingDay w) {
		this.w = w;
	}

	public WorkWeek getWw() {
		return ww;
	}

	public void setWw(WorkWeek ww) {
		this.ww = ww;
	}

	public WorkBlock getWb() {
		return wb;
	}

	public void setWb(WorkBlock wb) {
		this.wb = wb;
	}

	public String SSC() {
		return SUCCESS;
	}

	public String execute() {
        getWorkweeks();
        ww = workweeks.first();
        System.out.println(ww);
        for(WorkingDay w : ww.getWorkingdays()){
           System.out.println("HIER");
            System.out.println(w);
        for(WorkBlock wb : w.getWorkblocks()){
             
             System.out.println(wb);
        } 
    }
        ww.getWorkingdays();
        System.out.println(w);
         w.getWorkblocks();
         System.out.println(wb);
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