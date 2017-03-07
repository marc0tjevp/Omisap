package nl.scalda.pasimo.datalayer.testdao;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;

public class TestDAOWorkBlock implements IDAOWorkBlock {
	
	private Set <WorkBlock> workBlocks;
	
	public TestDAOWorkBlock(){
		this.workBlocks = new TreeSet<WorkBlock>();
		
		// test data
		
		this.workBlocks.add(new WorkBlock(1, "8:30", "10:10"));
	}

	@Override
	public void updateWorkBlock(WorkBlock workBlock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WorkBlock read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<WorkBlock> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
