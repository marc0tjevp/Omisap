package nl.scalda.pasimo.model.presenceregistration;

import java.util.GregorianCalendar;

public class CheckIn implements Comparable<CheckIn> {

	private int logID;
	private String cardID;
	private GregorianCalendar date;

	public CheckIn() {

	}

	public CheckIn(int logID, String cardID, int yearOfCheckIn, int monthOfCheckIn, int dayOfCheckIn, int hourOfCheckIn,
			int minuteOfCheckIn, int secondOfCheckIn) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(yearOfCheckIn, monthOfCheckIn, dayOfCheckIn, hourOfCheckIn, minuteOfCheckIn, secondOfCheckIn);
		this.date = gc;
		this.setLogID(logID);
		this.setCardID(cardID);

	}

	public String getFormattedTime() {
		String formattedHour = String.valueOf(getDate().get(GregorianCalendar.HOUR_OF_DAY)) + ":";
		String formattedMinutes;
		
		if (String.valueOf(getDate().get(GregorianCalendar.MINUTE)).length() != 2) {
			formattedMinutes = "0" + String.valueOf(getDate().get(GregorianCalendar.MINUTE));
		} else {
			formattedMinutes = String.valueOf(getDate().get(GregorianCalendar.MINUTE));
		}

		return formattedHour + formattedMinutes;
			
	}

	public String getFormattedDate() {
		return String.valueOf(getDate().get(GregorianCalendar.DAY_OF_MONTH)) + "-"
				+ String.valueOf(getDate().get(GregorianCalendar.MONTH)) + "-"
				+ String.valueOf(getDate().get(GregorianCalendar.YEAR));

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

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String toString() {
		return "CheckIn [DAY=" + this.getDate().get(GregorianCalendar.DAY_OF_MONTH) + ", Month="
				+ (this.getDate().get(GregorianCalendar.MONTH)) + ", Year="
				+ this.getDate().get(GregorianCalendar.YEAR) + ", Hour="
				+ this.getDate().get(GregorianCalendar.HOUR_OF_DAY) + ", Minute="
				+ this.getDate().get(GregorianCalendar.MINUTE) + ", Second="
				+ this.getDate().get(GregorianCalendar.SECOND) + "]";
		
	}

	@Override
	public int compareTo(CheckIn o) {
		return o.getDate().compareTo(this.date);

	}

}
