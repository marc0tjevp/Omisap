package nl.scalda.pasimo.datalayer.testdao;

import nl.scalda.pasimo.datalayer.interfaces.IDAOAcount;

public class TestDAOAcount implements IDAOAcount {

	private static TestDAOAcount instance = null;
	
	public static TestDAOAcount getInstance() {
		if (instance == null) {
			instance = new TestDAOAcount();
		}
		return instance;
	}
}
