package nl.scalda.pasimo.model.presenceregistration;

import java.util.GregorianCalendar;

public class CheckIn implements Comparable<CheckIn>{

	private int logID;
	private int cardID;
	private GregorianCalendar date;
	
	public CheckIn(){
		
	}
	
	public CheckIn(int logID, int cardID, int yearOfCheckIn, int monthOfCheckIn, int dayOfCheckIn, int hourOfCheckIn, int minuteOfCheckIn, int secondOfCheckIn){
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(yearOfCheckIn, monthOfCheckIn - 1, dayOfCheckIn, hourOfCheckIn, minuteOfCheckIn, secondOfCheckIn);
		this.date = gc;
		this.setLogID(logID);
		this.setCardID(cardID);
		
	}
	public String getFormattedTime(){
		return String.valueOf(getDate().get(GregorianCalendar.HOUR_OF_DAY))	+ ":" + String.valueOf(getDate().get(GregorianCalendar.MINUTE));
	}
	
	
	public String getFormattedDate(){
		
		return String.valueOf(getDate().get(GregorianCalendar.DAY_OF_MONTH)) + "-" 
				+ String.valueOf(getDate().get(GregorianCalendar.MONTH)) + "-" + String.valueOf(getDate().get(GregorianCalendar.YEAR));
				
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
	public int getCardID() {
		return cardID;
	}
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}
	
    public String toString() {
        return "CheckIn [DAY=" + this.getDate().get(GregorianCalendar.DAY_OF_MONTH) + 
        		", Month=" + (this.getDate().get(GregorianCalendar.MONTH)+1) +
                ", Year=" + this.getDate().get(GregorianCalendar.YEAR) + 
                ", Hour=" + this.getDate().get(GregorianCalendar.HOUR_OF_DAY) +
                ", Minute=" + this.getDate().get(GregorianCalendar.MINUTE) +
                ", Second=" + this.getDate().get(GregorianCalendar.SECOND) + "]";
    }

	@Override
	public int compareTo(CheckIn o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
