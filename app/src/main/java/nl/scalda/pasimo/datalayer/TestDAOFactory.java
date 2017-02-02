package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAONote;
import nl.scalda.pasimo.interfaces.IDAOTeacher;

/**
 * TODO: Move to .factory
 */
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
    public IDAOTeacher getDAOTeacher() {
        return TestDAOTeacher.getInstance();
    }

	@Override
	public IDAONote getDAONote() {
		return TestDAONote.getInstance();
	}

}
