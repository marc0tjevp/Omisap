package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAOCoachGroup;

public class TestDAOFactory extends DAOFactory {

    private static TestDAOFactory instance = null;

    private TestDAOFactory() {
    }

    @Override
    public IDAOCoachGroup getDAOCoachGroup() {
        return TestDAOCoachGroup.getInstance();
    }

    public static TestDAOFactory getInstance() {
        if (instance == null) {
            instance = new TestDAOFactory();
        }
        return instance;
    }
}
