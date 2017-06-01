package nl.scalda.pasimo.model.timeregistration;

import java.util.GregorianCalendar;

public class PasimoTime extends GregorianCalendar {
	
	public PasimoTime() {
		super();
	}
	
	public PasimoTime(int hour, int minute) {
		super();
		set(GregorianCalendar.HOUR, hour);
		set(GregorianCalendar.MINUTE, minute);
		
	}
	
	public PasimoTime(PasimoTime pt){
		super();
		
	}


	@Override
	public String toString(){
		return "time " + this.get(GregorianCalendar.HOUR)+ ":"+ this.get(GregorianCalendar.MINUTE);
		
	}
	
}
