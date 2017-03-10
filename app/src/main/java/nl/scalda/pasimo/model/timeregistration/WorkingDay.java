/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.model.timeregistration;

/**
 *
 * @author Diederik
 */
public class WorkingDay {
	
	public String name;
	
	public WorkingDay(String name){
		this.name = name;
	}
    
    public String wieIsErOpTijd(){
        return "Weet ik niet maar in iederig geval Diederik wel";
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
