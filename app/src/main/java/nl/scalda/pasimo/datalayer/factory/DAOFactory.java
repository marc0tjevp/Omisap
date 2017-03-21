package nl.scalda.pasimo.datalayer.factory;

import nl.scalda.pasimo.datalayer.interfaces.*;
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
    
    public abstract IDAOWorkingDay getDAOWorkingDay();
    
    public abstract IDAOWorkBlock getDAOWorkBlock();

}
