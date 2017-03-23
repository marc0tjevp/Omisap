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

/**
 *
 * @author Wesley
 */
public class TimeController extends ActionSupport {
	
	 public WorkBlock workBlock = new WorkBlock();
     public WorkingDay workingDay = new WorkingDay("");
	
public String read() {
	
	return SUCCESS;
}
	public String create() {
		workingDay.addWorkBlock(workBlock);
		workBlock.setStartTime("");
		workBlock.setEndTime("");
	
	//	workBlock.add(workingDay);
		
		return SUCCESS;
	}

	public String update() {
		return SUCCESS;
	}

	public String delete() {
		return SUCCESS;
	}
}
