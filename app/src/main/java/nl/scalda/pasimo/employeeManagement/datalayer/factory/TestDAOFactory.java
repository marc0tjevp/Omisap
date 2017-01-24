package nl.scalda.pasimo.employeeManagement.datalayer.factory;

import nl.scalda.pasimo.employeeManagement.datalayer.IDAOFactory;
import nl.scalda.pasimo.employeeManagement.datalayer.IEducationTeamDAO;
import nl.scalda.pasimo.employeeManagement.datalayer.impl.TestEducationTeamDAO;

public class TestDAOFactory implements IDAOFactory {

    @Override
    public IEducationTeamDAO getEducationTeamDAO() {
        return TestEducationTeamDAO.getInstance();
    }

}
