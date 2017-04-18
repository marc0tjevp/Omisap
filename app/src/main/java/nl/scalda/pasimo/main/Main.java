/**
 * 
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
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
//		WorkingDay w = new WorkingDay("maandag");
		
//		WorkBlock workblock = new WorkBlock(3, new PasimoTime(8, 30), new PasimoTime(10, 10));
		WorkBlock wq  = new WorkBlock(1, new PasimoTime(8, 30), new PasimoTime(10, 10));
		WorkBlock wq1 = new WorkBlock(2, new PasimoTime(10, 25), new PasimoTime(11, 15));
		WorkBlock wq2 = new WorkBlock(3, new PasimoTime(11, 25), new PasimoTime(12, 05));
		WorkBlock wq3 = new WorkBlock(4, new PasimoTime(12, 35), new PasimoTime(14, 15));
		WorkBlock wq4 = new WorkBlock(5, new PasimoTime(14, 30), new PasimoTime(15, 20));
		w.addWorkBlock(wq);
		w.addWorkBlock(wq1);
		w.addWorkBlock(wq2);
		w.addWorkBlock(wq3);
		w.addWorkBlock(wq4);	
		DAOFactory.getTheFactory().getDAOWorkBlock().read(2);
		
//		System.out.println(w);

	}
}


