/**
 * 
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
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
		WorkingDay w = new WorkingDay("maandag");
		
		WorkBlock workblock = new WorkBlock(3, new PasimoTime(8, 30), new PasimoTime(10, 10));
		
		workblock.setEnd(new PasimoTime(10 , 11));
		
		w.updateWorkBlock(workblock);
		
		System.out.println(w);

	}
}


