package nl.scalda.pasimo.model.timeregistration;



public class WorkBlock implements Comparable<WorkBlock> {

	public int id;
	public String startTime;
	public String endTime;

	public WorkBlock() {

	}

	public WorkBlock(int id, String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
        return "WorkBlock{" +
        		"id='" + id + '\'' +
                "startTime='" + startTime + '\'' +               ", endTime='" + endTime + '\'' +
                '}';
   }

	@Override
	public int compareTo(WorkBlock o) {
		
		return this.startTime.compareTo(o.getStartTime());
	}
	
}