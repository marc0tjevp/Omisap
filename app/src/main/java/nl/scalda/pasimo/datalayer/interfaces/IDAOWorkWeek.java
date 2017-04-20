package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.timeregistration.WorkWeek;

public interface IDAOWorkWeek {
	
	public WorkWeek read(int id);
	
	public TreeSet<WorkWeek> readAll();

}

	
		
	