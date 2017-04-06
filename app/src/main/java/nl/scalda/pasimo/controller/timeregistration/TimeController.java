/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.controller.timeregistration;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;



public class TimeController extends ActionSupport {
	
WorkingDay w = new WorkingDay("");
WorkBlock workblock = new WorkBlock(12 ,"", "");
	

	public String execute() {

		return SUCCESS;
	}
 public String createWorkBlock(WorkBlock workblock) {
	 workblock.setId(0);
	 workblock.setStartTime("");
	 workblock.setEndTime("");
	 w.addWorkBlock(workblock);
	return SUCCESS;
	 
}
 public String updateWorkBlock(WorkBlock workblock){
	 workblock.setId(0);
	 workblock.setStartTime("");
	 workblock.setEndTime("");
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
