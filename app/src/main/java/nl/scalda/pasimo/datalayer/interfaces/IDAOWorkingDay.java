package nl.scalda.pasimo.datalayer.interfaces;

import nl.scalda.pasimo.model.timeregistration.WorkingDay;

public interface IDAOWorkingDay {

	public WorkingDay read(String name);
	
	public void create(WorkingDay workingday);
	
	public void delete(WorkingDay workingday);
	
}