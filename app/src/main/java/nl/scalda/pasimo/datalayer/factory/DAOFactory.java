package nl.scalda.pasimo.datalayer.factory;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCheckIn;
import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAOEducationTeam;
import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeam;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkBlock;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkingDay;

public abstract class DAOFactory {

    protected static DAOFactory theFactory;

    public static DAOFactory getTheFactory() {
        return theFactory;
    }

    public static void setTheFactory(DAOFactory factory) {
        theFactory = factory;
    }

    public abstract IDAOTeam getDAOTeam();

    public abstract IDAOEducationTeam getDAOEducationTeam();

    public abstract IDAOCoachGroup getDAOCoachGroup();

    public abstract IDAOLessonGroup getDAOLessonGroup();

    public abstract IDAONote getDAONote();

    public abstract IDAOTeacher getDAOTeacher();

    public abstract IDAOWorkingDay getDAOWorkingDay();

    public abstract IDAOWorkBlock getDAOWorkBlock();
    
    public abstract IDAOStudent getDAOStudent();
    
    public abstract IDAOCheckIn getTestDAOCheckIn();

}
