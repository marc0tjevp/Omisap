package nl.scalda.pasimo.model.timeregistration;

import java.util.GregorianCalendar;

public class PasimoTime extends GregorianCalendar {
	
	public PasimoTime(int id, int startHour, int startMinute) {
		super();
		set(GregorianCalendar.HOUR, startHour);
		set(GregorianCalendar.MINUTE, startMinute);
		
	}
	
	public PasimoTime(int endHour, int endMinute){
		super();
		set(GregorianCalendar.HOUR, endHour);
		set(GregorianCalendar.MINUTE, endMinute);
	}

}
