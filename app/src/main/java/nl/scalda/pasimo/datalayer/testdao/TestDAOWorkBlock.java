package nl.scalda.pasimo.datalayer.testdao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;

public class TestDAOWorkBlock implements IDAOWorkBlock {

	private static TestDAOWorkBlock instance = null;
	private Set<WorkBlock> workblocks;

	private TestDAOWorkBlock() {
		this.workblocks = new TreeSet<WorkBlock>();

		this.workblocks.add(new WorkBlock(1, "8:30", "10:10"));
		this.workblocks.add(new WorkBlock(1, "10:25", "11:15"));
		this.workblocks.add(new WorkBlock(1, "11:25", "12:05"));
		this.workblocks.add(new WorkBlock(1, "12:35", "14:15"));
	}

	// was eerst private die static
	public static TestDAOWorkBlock getInstance() {
		if (instance == null) {
			instance = new TestDAOWorkBlock();
		}
		return instance;
	}

	@Override
	public void update(WorkBlock workblock) {
		workblock.setId(workblock.getId());
		workblock.setStartTime(workblock.getStartTime());
		workblock.setEndTime(workblock.getEndTime());

	}

	@Override
	public void create(WorkBlock workblock) {
		this.workblocks.add(workblock);

	}

	@Override
	public void delete(WorkBlock workblock) {
	this.workblocks.remove(workblock);
	}

	@Override
	public Set<WorkBlock> readAll() {

		return workblocks;

	}

	@Override
	public WorkBlock read(int id) {

		return read(id);
	}

}