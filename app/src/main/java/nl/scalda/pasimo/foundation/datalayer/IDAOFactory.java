package nl.scalda.pasimo.foundation.datalayer;

import nl.scalda.pasimo.employeeManagement.datalayer.IEducationTeamDAO;
import nl.scalda.pasimo.employeeManagement.datalayer.ITeamDAO;
import nl.scalda.pasimo.employeeManagement.datalayer.impl.TestEducationTeamDAO;

public interface IDAOFactory {

    public IEducationTeamDAO getEducationTeamDAO();

    public ITeamDAO getTeamDAO();

}
