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
static	WorkingDay w = new WorkingDay("Maandag");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WorkWeek week = new WorkWeek(1);
		

		
		WorkingDay workingday = new WorkingDay("maandag");
		
		
	
		

		
		System.out.println(workingday);
		
		DAOFactory.getTheFactory().getDAOWorkWeek().readAll();
		

	}
}


