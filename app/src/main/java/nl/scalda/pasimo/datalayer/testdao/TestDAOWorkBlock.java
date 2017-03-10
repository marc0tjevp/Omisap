package nl.scalda.pasimo.datalayer.testdao;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;

public class TestDAOWorkBlock implements IDAOWorkBlock {

	private Set<WorkBlock> workBlocks;

	public TestDAOWorkBlock() {
		this.workBlocks = new TreeSet<WorkBlock>();

		// test data

		this.workBlocks.add(new WorkBlock(1, "8:30", "10:10"));
	}

	@Override
	public void add(WorkBlock workBlock) {
		this.workBlocks.add(workBlock);

	}

	@Override
	public void delete(WorkBlock workBlock) {
		this.workBlocks.remove(workBlock);

	}

	@Override
	public void update(WorkBlock workBlock) {
		WorkBlock target = this.read(workBlock.getId());

		target.setId(workBlock.getId());
		target.setStartTime(workBlock.getStartTime());
		target.setEndTime(workBlock.getEndTime());

	}

	@Override
	public WorkBlock read(int id) {
		for (WorkBlock workblock : this.workBlocks) {
			if (workblock.getId() == (id))
				return workblock;
		}

		return null;
	}

	@Override
	public Set<WorkBlock> readAll() {

		return this.workBlocks;
	}
	
	private static TestDAOWorkBlock instance;

	public static TestDAOWorkBlock getInstance() {
		if(instance == null){
		instance = new TestDAOWorkBlock();
	
		}
		return instance;
	}
}
