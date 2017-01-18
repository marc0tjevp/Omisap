package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAOLessonGroup;

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
	public IDAOLessonGroup getDAOLessonGroup() {
		return TestDAOLessonGroup.getInstance();
	}

}
