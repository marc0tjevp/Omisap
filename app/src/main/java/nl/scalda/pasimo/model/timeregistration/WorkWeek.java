package nl.scalda.pasimo.model.timeregistration;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;

public class WorkWeek implements Comparable<WorkWeek> {
	
	 
	private static WorkWeek instance = null;
	private int id;
	private TreeSet <WorkingDay> workingdays;

	
	public WorkWeek(int id){
		this.id = id;
		this.workingdays = new TreeSet<WorkingDay>();
	}


	public static WorkWeek getInstance(){
		if(instance == null){
			instance = new WorkWeek(1);
		}
		return instance;
	}


	public TreeSet<WorkingDay> getWorkingdays() {
		return workingdays;
	}


	public void setWorkingdays(TreeSet<WorkingDay> workingdays) {
		this.workingdays = workingdays;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void addWorkingDay(WorkingDay workingday){
		System.out.println(this.workingdays);
		System.out.println(workingday);
		this.workingdays.add(workingday);
		
		DAOFactory.getTheFactory().getDAOWorkingDay().create(workingday);
	}
	
	public void deleteWorkingDay(WorkingDay workingday){
		this.workingdays.remove(workingday);
		DAOFactory.getTheFactory().getDAOWorkingDay().delete(workingday);
	}

	@Override
	public int compareTo(WorkWeek arg0) {
		
		return 0;
	}
	
	@Override
	public String toString(){
		return "id = " + id ;
		
	}

}
