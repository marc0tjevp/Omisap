package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.employeemanagement.datalayer.test.TestDAONote;
import nl.scalda.pasimo.employeemanagement.interfaces.IDAONote;

public class TestDAOFactory extends DAOFactory {

    private static TestDAOFactory instance = null;

    private TestDAOFactory() {
    }

    public static TestDAOFactory getInstance() {
        if (instance == null) {
            instance = new TestDAOFactory();
        }
        return instance;
    }

	@Override
	public IDAONote getDAONote() {
		return TestDAONote.getInstance();
	}

}
