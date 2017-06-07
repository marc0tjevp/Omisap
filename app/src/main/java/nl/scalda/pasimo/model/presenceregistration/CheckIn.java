package nl.scalda.pasimo.model.presenceregistration;

import java.util.GregorianCalendar;


public class CheckIn implements Comparable<CheckIn> {

	private int logID;
	private GregorianCalendar date;
	private boolean isCheckIn;
	
	public CheckIn(int logID, int hourOfCheckIn, int minuteOfCheckIn, int secondOfCheckIn, boolean isCheckIn){
		this.setLogID(logID);
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(hourOfCheckIn, minuteOfCheckIn, secondOfCheckIn);
		this.date = gc;
		this.setIsCheckIn(isCheckIn);
	}
	
	public Boolean getIsCheckIn(){
		return isCheckIn;
	}
	
	public void setIsCheckIn(Boolean isCheckIn){
		this.isCheckIn = isCheckIn;
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	public int getLogID() {
		return logID;
	}
	public void setLogID(int logID) {
		this.logID = logID;
	}
	
	private String getTimeString(){
		return date.get(GregorianCalendar.HOUR_OF_DAY) + ":" + date.get(GregorianCalendar.MINUTE) + ":" + date.get(GregorianCalendar.SECOND);
	}
	
    public String toString() {
        return getTimeString();
    }

	@Override
	public int compareTo(CheckIn o) {
		return this.date.compareTo(o.getDate());
	}

	
}
