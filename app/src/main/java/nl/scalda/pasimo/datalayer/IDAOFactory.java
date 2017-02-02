package nl.scalda.pasimo.datalayer;

public interface IDAOFactory {

    ITeamDAO getTeamDAO();

    IEducationTeamDAO getEducationTeamDAO();

}
