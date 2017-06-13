package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkWeek;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

public interface IDAOWorkWeek {
	
	public WorkWeek read(int id);
	
	public TreeSet<WorkWeek> readAll();
	
	public TreeSet<WorkingDay> readAllWorkingDays();
	
	public TreeSet<WorkBlock> readAllWorkBlocks();

}

	
		
	