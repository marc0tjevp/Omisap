package nl.scalda.pasimo.employeeManagement.datalayer.impl;

import nl.scalda.pasimo.employeeManagement.datalayer.IEducationTeamDAO;
import nl.scalda.pasimo.employeeManagement.exception.AlreadyExistException;
import nl.scalda.pasimo.employeeManagement.exception.DoesNotExistException;
import nl.scalda.pasimo.employeeManagement.model.EducationTeam;

import java.util.TreeSet;

public class TestEducationTeamDAO implements IEducationTeamDAO {

    private TreeSet<EducationTeam> educationTeams;

    public TestEducationTeamDAO() {
        this.educationTeams = new TreeSet<EducationTeam>();
    }

    @Override
    public EducationTeam create(EducationTeam educationTeam) throws AlreadyExistException {

        if (!this.educationTeams.add(educationTeam))
            throw new AlreadyExistException("EducationTeam(" + educationTeam.getAbbreviation() + ") already exists!");

        return educationTeam;
    }

    @Override
    public EducationTeam update(EducationTeam educationTeam) throws DoesNotExistException {

        EducationTeam target = this.read(educationTeam.getAbbreviation());

        if (target == null)
            throw new DoesNotExistException("EducationTeam(" + educationTeam.getAbbreviation() + ") does not exist!");

        target.setName(educationTeam.getName());
        target.setCoachGroups(educationTeam.getCoachGroups());
        target.setLessonGroup(educationTeam.getLessonGroup());

        return target;
    }

    @Override
    public EducationTeam save(EducationTeam educationTeam) {

        try {
            return this.create(educationTeam);
        } catch (AlreadyExistException e) {
            return this.update(educationTeam);
        }

    }

    @Override
    public void delete(EducationTeam educationTeam) throws DoesNotExistException {

        if (!this.educationTeams.remove(educationTeam))
            throw new DoesNotExistException("EducationTeam(" + educationTeam.getAbbreviation() + ") does not exist!");

    }

    @Override
    public EducationTeam read(String abbreviation) {

        for (EducationTeam educationTeam : this.educationTeams) {
            if (educationTeam.getAbbreviation().equals(abbreviation))
                return educationTeam;
        }

        return null;
    }

    @Override
    public TreeSet<EducationTeam> readAll() {
        return this.educationTeams;
    }

}
