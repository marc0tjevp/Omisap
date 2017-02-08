package nl.scalda.pasimo.datalayer.factory;

import nl.scalda.pasimo.datalayer.TestEducationTeamDAO;
import nl.scalda.pasimo.datalayer.TestTeamDAO;
import nl.scalda.pasimo.interfaces.*;

public abstract class DAOFactory {

    protected static DAOFactory theFactory;

    public static DAOFactory getTheFactory() {
        return theFactory;
    }

    public static void setTheFactory(DAOFactory factory) {
        theFactory = factory;
    }
//methods

    public abstract ITeamDAO getTeamDAO();

    public abstract IEducationTeamDAO getEducationTeamDAO();

    public abstract IDAOCoachGroup getDAOCoachGroup();

    public abstract IDAOLessonGroup getDAOLessonGroup();

    public abstract IDAONote getDAONote();

    public abstract IDAOTeacher getDAOTeacher();

}
