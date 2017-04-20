package nl.scalda.pasimo.datalayer.testdao;


import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkingDay;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

public class TestDAOWorkingDay implements IDAOWorkingDay {

	private Set<WorkingDay> workingdays;

	public TestDAOWorkingDay() {
		this.workingdays = new TreeSet<WorkingDay>();

		this.workingdays.add(new WorkingDay("Maandag"));

	}

	@Override
	public WorkingDay read(String name) {
		for (WorkingDay workingday : this.workingdays) {
			if (workingday.getName() == (name)) {
			}

		}
		return null;

	}

	private static TestDAOWorkingDay instance;

	public static TestDAOWorkingDay getInstance() {
		if (instance == null) {
			instance = new TestDAOWorkingDay();

		}
		return instance;
	}

	@Override
	public void create(WorkingDay workingday) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(WorkingDay workingday) {
		// TODO Auto-generated method stub
		
	}

}