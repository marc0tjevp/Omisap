package nl.scalda.pasimo.test;
import java.text.ParseException;
import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOFactory;

public class testClass {

	public static void main(String[] args) throws ParseException{
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		
		
	}

}

/*
// create a GregorianCalendar with the Pacific Daylight time zone
// and the current date and time
Calendar calendar = new GregorianCalendar(pdt);
Date trialTime = new Date();
calendar.setTime(trialTime);

// print out a bunch of interesting things
System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
System.out.println("DATE: " + calendar.get(Calendar.DATE));
System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
*/
