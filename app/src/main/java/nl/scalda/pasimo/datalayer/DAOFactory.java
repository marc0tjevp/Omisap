package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAOCoachGroup;

public abstract class DAOFactory {

//    protected static DAOFactory theFactory = TestDAOFactory.getInstance();
    protected static DAOFactory theFactory = MySQLDAOFactory.getInstance();

    public static DAOFactory getTheFactory() {
        return theFactory;
    }

    public static void setTheFactory(DAOFactory factory) {
        theFactory = factory;
    }
//methods
    public abstract IDAOCoachGroup getDAOCoachGroup();

}
