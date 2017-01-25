package nl.scalda.pasimo.foundation.datalayer.factory;

import nl.scalda.pasimo.employeeManagement.datalayer.IEducationTeamDAO;
import nl.scalda.pasimo.employeeManagement.datalayer.impl.TestEducationTeamDAO;
import nl.scalda.pasimo.foundation.datalayer.IDAOFactory;

public class TestDAOFactory implements IDAOFactory {

    @Override
    public IEducationTeamDAO getEducationTeamDAO() {
        return TestEducationTeamDAO.getInstance();
    }

}
