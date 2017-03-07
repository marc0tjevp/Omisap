package nl.scalda.pasimo.model.timeregistration;

public class WorkBlock {

	public int id;
	public String startTime;
	public String endTime;

	
	public WorkBlock(){
		
	}
	
	public WorkBlock(int id, String startTime, String endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
