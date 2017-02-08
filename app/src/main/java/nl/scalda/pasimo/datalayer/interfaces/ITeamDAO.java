package nl.scalda.pasimo.datalayer.interfaces;

import nl.scalda.pasimo.model.employeemanagement.Team;

public interface ITeamDAO {

    /**
     * @return - The requested Team if one exist with that abbreviation.
     * Null otherwise.
     */
    public Team read(String abbreviation);

}
