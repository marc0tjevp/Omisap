package nl.scalda.pasimo.datalayer.interfaces;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

import java.util.Set;

public interface IDAOEducationTeam {

    /**
     * Creates the EducationTeam.
     */
    void create(EducationTeam educationTeam);

    /**
     * Updates the EducationTeam.
     */
    void update(EducationTeam educationTeam);

    /**
     * Creates the EducationTeam (if not exists) saves the EducationTeam
     * otherwise.
     */
    void save(EducationTeam educationTeam);

    /**
     * Deletes the EducationTeam.
     */
    void delete(EducationTeam educationTeam);

    /**
     * @return - The requested EducationTeam if one exist with that
     * abbreviation. Null otherwise.
     */
    EducationTeam read(String abbreviation);

    /**
     * @return - All education teams.
     */
    Set<EducationTeam> readAll();

    /**
     * Get whether an EducationTeam exists.
     *
     * @return - Whether that EducationTeam exists.
     */
    boolean exist(String abbr);

    void addTeacherToEducationTeam(Teacher teacher, EducationTeam educationTeam);

    void deleteTeacherFromEducationTeam(Teacher teacher, EducationTeam educationTeam);

}
