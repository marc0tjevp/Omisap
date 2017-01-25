package nl.scalda.pasimo.employeeManagement.datalayer.impl;

import nl.scalda.pasimo.employeeManagement.datalayer.IEducationTeamDAO;
import nl.scalda.pasimo.employeeManagement.model.EducationTeam;
import nl.scalda.pasimo.foundation.service.DAOFactoryService;

import java.util.TreeSet;

public class TestEducationTeamDAO implements IEducationTeamDAO {

    private TreeSet<EducationTeam> educationTeams;

    public TestEducationTeamDAO() {
        this.educationTeams = new TreeSet<EducationTeam>();
    }

    @Override
    public void create(EducationTeam educationTeam) {
        this.educationTeams.add(educationTeam);
    }

    @Override
    public void update(EducationTeam educationTeam) {

        EducationTeam target = this.read(educationTeam.getAbbreviation());

        target.setName(educationTeam.getName());
        target.setCoachGroups(educationTeam.getCoachGroups());

    }

    @Override
    public void save(EducationTeam educationTeam) {

        if (this.exist(educationTeam)) {
            this.update(educationTeam);
        } else {
            this.create(educationTeam);
        }

    }

    @Override
    public void delete(EducationTeam educationTeam) {
        this.educationTeams.remove(educationTeam);
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

    @Override
    public boolean exist(EducationTeam educationTeam) {
        return this.educationTeams.contains(educationTeam);
    }

    @Override
    public boolean exist(String abbreviation) {

        for (EducationTeam educationTeam : this.educationTeams) {
            if (educationTeam.getAbbreviation().equals(abbreviation))
                return true;
        }

        return false;
    }

    private static TestEducationTeamDAO instance;

    public static TestEducationTeamDAO getInstance()
    {
        if (instance == null)
            instance = new TestEducationTeamDAO();
        return instance;
    }

}
