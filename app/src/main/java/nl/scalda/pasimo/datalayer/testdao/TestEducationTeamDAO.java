package nl.scalda.pasimo.datalayer.testdao;

import nl.scalda.pasimo.interfaces.IEducationTeamDAO;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;

import java.util.Set;
import java.util.TreeSet;

public class TestEducationTeamDAO implements IEducationTeamDAO {

    private Set<EducationTeam> educationTeams;

    private TestEducationTeamDAO() {
        this.educationTeams = new TreeSet<EducationTeam>();

        // Test data
        this.educationTeams.add(new EducationTeam("AO", "Applicatieontwikkelaar"));
        this.educationTeams.add(new EducationTeam("SSC", "Shared Service Center"));
        this.educationTeams.add(new EducationTeam("MV", "Mediavormgeving"));

    }

    @Override
    public void create(EducationTeam educationTeam) {
        this.educationTeams.add(educationTeam);
    }

    @Override
    public void update(EducationTeam educationTeam) {

        EducationTeam target = this.read(educationTeam.getAbbreviation());

        target.setAbbreviation(educationTeam.getAbbreviation());
        target.setName(educationTeam.getName());

    }

    @Override
    public void save(EducationTeam educationTeam) {

        if (this.exist(educationTeam.getAbbreviation())) {
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
    public Set<EducationTeam> readAll() {
        return this.educationTeams;
    }

    @Override
    public boolean exist(String abbreviation) {

        for (EducationTeam educationTeam : this.educationTeams) {
            if (educationTeam.getAbbreviation().equals(abbreviation))
                return true;
        }

        return false;
    }

    // --------------------------------------------------
    // Singleton

    private static TestEducationTeamDAO instance;

    public static TestEducationTeamDAO getInstance()
    {
        if (instance == null)
            instance = new TestEducationTeamDAO();
        return instance;
    }

}
