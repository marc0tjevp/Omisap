package nl.scalda.pasimo.interfaces;

import nl.scalda.pasimo.interfaces.IEducationTeamDAO;
import nl.scalda.pasimo.interfaces.ITeamDAO;

public interface IDAOFactory {

    ITeamDAO getTeamDAO();

    IEducationTeamDAO getEducationTeamDAO();

}
