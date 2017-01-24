package nl.scalda.pasimo.employeeManagement.datalayer;

import nl.scalda.pasimo.employeeManagement.exception.AlreadyExistException;
import nl.scalda.pasimo.employeeManagement.exception.DoesNotExistException;
import nl.scalda.pasimo.employeeManagement.model.EducationTeam;

import java.util.TreeSet;

public interface IEducationTeamDAO {

    /**
     * Creates the EducationTeam.
     *
     * @return - The EducationTeam contained by the DAO.
     * @throws DoesNotExistException - Exception is thrown when the EducationTeam already exist.
     */
    public EducationTeam create(EducationTeam educationTeam) throws AlreadyExistException;

    /**
     * Updates the EducationTeam.
     *
     * @return - The EducationTeam contained by the DAO.
     */
    public EducationTeam update(EducationTeam educationTeam) throws DoesNotExistException;

    /**
     * Creates the EducationTeam (if not exists) saves the EducationTeam otherwise.
     *
     * @return - The EducationTeam contained by the DAO.
     */
    public EducationTeam save(EducationTeam educationTeam);

    /**
     * Deletes the EducationTeam.
     *
     * @throws DoesNotExistException - If the EducationTeam did not exist.
     */
    public void delete(EducationTeam educationTeam) throws DoesNotExistException;

    /**
     * @return - The requested EducationTeam if one exist with that abbreviation.
     * Null otherwise.
     */
    public EducationTeam read(String abbreviation);

    /**
     * @return - All education teams.
     */
    public TreeSet<EducationTeam> readAll();

}
