package nl.scalda.pasimo.service;

import nl.scalda.pasimo.datalayer.IDAOFactory;

public class DAOFactoryService {

    private IDAOFactory factory;

    public void setFactory(IDAOFactory factory)
    {
        this.factory = factory;
    }

    public IDAOFactory getFactory()
    {
        return this.factory;
    }

    /**
     * Singleton of DAOFactoryService.
     */
    private static DAOFactoryService instance;

    /**
     * @return Singleton of DAOFactoryService
     */
    public static DAOFactoryService getInstance()
    {
        if (instance == null)
            instance = new DAOFactoryService();
        return instance;
    }

}
