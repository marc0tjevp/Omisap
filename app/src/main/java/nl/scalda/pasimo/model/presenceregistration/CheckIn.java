package nl.scalda.pasimo.model.presenceregistration;

import java.util.Date;

public class CheckIn {

	private int logID;
	Date date = new Date();
	private String cardID;
	
	public CheckIn(){
		
	}
	
	public CheckIn(int logID, Date date, String cardID){
		this.setLogID(logID);
		this.setDate(date);
		this.setCardID(cardID);
	}
	
	
	
	
	public int getLogID() {
		return logID;
	}
	public void setLogID(int logID) {
		this.logID = logID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	
}
