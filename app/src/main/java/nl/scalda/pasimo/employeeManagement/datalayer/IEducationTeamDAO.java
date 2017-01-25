package nl.scalda.pasimo.employeeManagement.datalayer;

import nl.scalda.pasimo.employeeManagement.model.EducationTeam;

import java.util.TreeSet;

public interface IEducationTeamDAO {

    /**
     * Creates the EducationTeam.
     */
    public void create(EducationTeam educationTeam);

    /**
     * Updates the EducationTeam.
     */
    public void update(EducationTeam educationTeam);

    /**
     * Creates the EducationTeam (if not exists) saves the EducationTeam otherwise.
     */
    public void save(EducationTeam educationTeam);

    /**
     * Deletes the EducationTeam.
     */
    public void delete(EducationTeam educationTeam);

    /**
     * @return - The requested EducationTeam if one exist with that abbreviation.
     * Null otherwise.
     */
    public EducationTeam read(String abbreviation);

    /**
     * @return - All education teams.
     */
    public TreeSet<EducationTeam> readAll();

    /**
     * Get whether an EducationTeam exists.
     *
     * @return - Whether that EducationTeam exists.
     */
    public boolean exist(EducationTeam educationTeam);

    /**
     * Get whether an EducationTeam exists.
     *
     * @return - Whether that EducationTeam exists.
     */
    public boolean exist(String abbreviation);

}
