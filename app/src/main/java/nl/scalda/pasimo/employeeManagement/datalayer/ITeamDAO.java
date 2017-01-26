package nl.scalda.pasimo.employeeManagement.datalayer;

import nl.scalda.pasimo.employeeManagement.model.Team;

public interface ITeamDAO {

    /**
     * @return - The requested Team if one exist with that abbreviation.
     * Null otherwise.
     */
    public Team read(String abbreviation);

}
