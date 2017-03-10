package nl.scalda.pasimo.datalayer.testdao;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkingDay;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

public class TestDAOWorkingDay implements IDAOWorkingDay {

	private Set <WorkingDay> workingdays;
	
	public TestDAOWorkingDay(){
		this.workingdays = new TreeSet<WorkingDay>();
		
		this.workingdays.add(new WorkingDay("Maandag"));
		
	}
	
	
	@Override
	public void read(String name) {
		for(WorkingDay workingday : this.workingdays){
			if(workingday.getName() == (name)){
						}
		

			
		}
		
	}

}
