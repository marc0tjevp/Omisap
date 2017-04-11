package nl.scalda.pasimo.model.presenceregistration;

import java.util.GregorianCalendar;

import nl.scalda.pasimo.model.employeemanagement.Person;

public class CheckIn extends Person {

	private int logID;
	private GregorianCalendar date;
	
	public CheckIn(String firstName, String insertion, String lastName){
		super(firstName, insertion, lastName);
	}
	
	public CheckIn(int logID, String cardID, int yearOfCheckIn, int monthOfCheckIn, int dayOfCheckIn, int hourOfCheckIn, int minuteOfCheckIn, int secondOfCheckIn){
		super(cardID);
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(yearOfCheckIn, monthOfCheckIn - 1, dayOfCheckIn, hourOfCheckIn, minuteOfCheckIn, secondOfCheckIn);
		this.date = gc;
		this.setLogID(logID);
		
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
	
    public String toString() {
        return "CheckIn [DAY=" + this.getDate().get(GregorianCalendar.DAY_OF_MONTH) + 
        		", Month=" + (this.getDate().get(GregorianCalendar.MONTH)+1) +
                ", Year=" + this.getDate().get(GregorianCalendar.YEAR) + 
                ", Hour=" + this.getDate().get(GregorianCalendar.HOUR_OF_DAY) +
                ", Minute=" + this.getDate().get(GregorianCalendar.MINUTE) +
                ", Second=" + this.getDate().get(GregorianCalendar.SECOND) + "]";
    }

	
}
