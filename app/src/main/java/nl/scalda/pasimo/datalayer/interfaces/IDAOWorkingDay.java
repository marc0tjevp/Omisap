package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.timeregistration.WorkingDay;

public interface IDAOWorkingDay {

	public TreeSet workingdays(String name);
	
	public void create(WorkingDay workingday);
	
	public void delete(WorkingDay workingday);
	
}