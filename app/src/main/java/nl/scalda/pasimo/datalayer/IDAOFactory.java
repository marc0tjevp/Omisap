package nl.scalda.pasimo.datalayer;

public interface IDAOFactory {

    public IEducationTeamDAO getEducationTeamDAO();

    public ITeamDAO getTeamDAO();

}
