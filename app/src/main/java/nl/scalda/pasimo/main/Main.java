/**
 * 
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkWeek;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

/**
 * @author Bram van Huele
 * Pasimo
 * 12 apr. 2017
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WorkWeek week = new WorkWeek(1);
		

		
		WorkingDay workingday = new WorkingDay("maandag");
		
		workingday.setName("Kutdag");
	
		

		
		System.out.println(workingday);
		
		DAOFactory.getTheFactory().getDAOWorkingDay().read("maandag");
		

	}
}


