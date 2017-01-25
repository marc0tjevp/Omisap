package nl.scalda.pasimo.service;

import nl.scalda.pasimo.foundation.service.DAOFactoryService;

public class Service {

    private static Service instance = null;

    private Service() {
    }

    public static DAOFactoryService getDAOFactoryService()
    {
        return DAOFactoryService.getInstance();
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

}
