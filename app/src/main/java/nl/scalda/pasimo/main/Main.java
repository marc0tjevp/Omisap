/**
 * 
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOCheckIn;

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
	TestDAOCheckIn.getInstance().readAll();

	}

}
