package nl.scalda.pasimo.datalayer.interfaces;

import java.util.Set;

import nl.scalda.pasimo.model.timeregistration.WorkBlock;

public interface IDAOWorkBlock {

	
	public void updateWorkBlock(WorkBlock workBlock);
		
	public WorkBlock read(int id);
	
	public Set <WorkBlock> readAll();
}
