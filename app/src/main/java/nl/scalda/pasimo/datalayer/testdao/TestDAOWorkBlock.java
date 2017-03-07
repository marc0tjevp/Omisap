package nl.scalda.pasimo.datalayer.testdao;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.model.timeregistration.WorkBlock;

public class TestDAOWorkBlock {
	
	private Set <WorkBlock> workBlocks;
	
	public TestDAOWorkBlock(){
		this.workBlocks = new TreeSet<WorkBlock>();
		
		// test data
		this.workBlocks.add(new WorkBlock("8:30", "10:10"));
	}

}
