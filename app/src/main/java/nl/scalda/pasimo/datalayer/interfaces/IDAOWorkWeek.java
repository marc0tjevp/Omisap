package nl.scalda.pasimo.datalayer.interfaces;

import nl.scalda.pasimo.model.timeregistration.WorkWeek;

public interface IDAOWorkWeek {
	
	public WorkWeek read(int id);
	
	public WorkWeek readAll(int id);

}

	
		
	