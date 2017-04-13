/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.controller.timeregistration;

import java.util.TreeSet;

import org.apache.struts2.components.Set;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

public class TimeController extends ActionSupport {

	 public TreeSet<WorkBlock> WorkBlocks = new TreeSet<>();

	WorkingDay w = new WorkingDay("Maandag");

	public String SSC() {

		return SUCCESS;

	}


	public String execute() {

		WorkBlock wq  = new WorkBlock(1, new PasimoTime(8, 30), new PasimoTime(10, 10));
		WorkBlock wq1 = new WorkBlock(2, new PasimoTime(10, 25), new PasimoTime(11, 15));
		WorkBlock wq2 = new WorkBlock(3, new PasimoTime(11, 25), new PasimoTime(12, 05));
		WorkBlock wq3 = new WorkBlock(4, new PasimoTime(12, 35), new PasimoTime(14, 15));
		WorkBlock wq4 = new WorkBlock(5, new PasimoTime(14, 30), new PasimoTime(15, 20));
		w.addWorkBlock(wq);
		w.addWorkBlock(wq1);
		w.addWorkBlock(wq2);
		w.addWorkBlock(wq3);
		w.addWorkBlock(wq4);
//		WorkBlocks.remove(wq);
//		WorkBlocks.remove(wq1);
//		WorkBlocks.remove(wq2);
//		WorkBlocks.remove(wq3);
//		WorkBlocks.remove(wq4);
		
		
//		WorkBlocks.add(wq);
//		WorkBlocks.add(wq1);
//		WorkBlocks.add(wq2);
//		WorkBlocks.add(wq3);
//		WorkBlocks.add(wq4);
		
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
		workblock.setId(0);
		workblock.setStart(null);
		workblock.setEnd(null);
		w.updateWorkBlock(workblock);
		return SUCCESS;
	}

	public String removeWorkBlock(WorkBlock workblock) {
		w.deleteWorkBlock(workblock);

		return SUCCESS;
	}

	public String readWorkBlock() {
		return SUCCESS;
	}


}
