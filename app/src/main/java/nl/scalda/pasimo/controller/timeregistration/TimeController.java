/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.controller.timeregistration;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

/**
 *
 * @author Diederik
 */
public class TimeController extends ActionSupport {

	WorkingDay w = new WorkingDay("maandag");

	public String execute() {

		return SUCCESS;
	}

	public String removeWorkBlock(WorkBlock workblock) {
		w.deleteWorkBlock(workblock);

		return SUCCESS;
	}

}
