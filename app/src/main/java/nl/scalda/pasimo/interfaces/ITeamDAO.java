package nl.scalda.pasimo.interfaces;

import nl.scalda.pasimo.model.employeeManagement.Team;

public interface ITeamDAO {

    /**
     * @return - The requested Team if one exist with that abbreviation.
     * Null otherwise.
     */
    public Team read(String abbreviation);

}
