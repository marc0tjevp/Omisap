package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;

import nl.scalda.pasimo.interfaces.IDAONote;
import nl.scalda.pasimo.interfaces.IDAOTeacher;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IDAOEducationTeam;

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

    public abstract IDAONote getDAONote();
    
    public abstract IDAOTeacher getDAOTeacher();

    public abstract IDAOLessonGroup getDAOLessonGroup();
    
    public abstract IDAOEducationTeam getDAOEducationTeam();

}
