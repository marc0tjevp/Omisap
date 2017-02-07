package nl.scalda.pasimo.datalayer.factory;

import nl.scalda.pasimo.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IDAONote;
import nl.scalda.pasimo.interfaces.IDAOTeacher;

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

    public abstract IDAONote getDAONote();

    public abstract IDAOTeacher getDAOTeacher();

}
