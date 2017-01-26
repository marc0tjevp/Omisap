package nl.scalda.pasimo.datalayer.factory;

import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.interfaces.*;

public class TestDAOFactory extends DAOFactory {

    private static TestDAOFactory instance = null;

    private TestDAOFactory() {
    }

    @Override
    public IDAOCoachGroup getDAOCoachGroup() {
        return TestDAOCoachGroup.getInstance();
    }

    @Override
    public IDAOLessonGroup getDAOLessonGroup() {
        return TestDAOLessonGroup.getInstance();
    }

    public static TestDAOFactory getInstance() {
        if (instance == null) {
            instance = new TestDAOFactory();
        }
        return instance;
    }
}
