package nl.scalda.pasimo.datalayer.factory;

import nl.scalda.pasimo.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;

public abstract class DAOFactory {

    protected static DAOFactory theFactory;

    public static DAOFactory getTheFactory() {
        return theFactory;
    }

    public static void setTheFactory(DAOFactory factory) {
        theFactory = factory;
    }
//methods

    public abstract IDAOCoachGroup getDAOCoachGroup();

    public abstract IDAOLessonGroup getDAOLessonGroup();

}
