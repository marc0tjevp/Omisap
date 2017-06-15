package nl.scalda.pasimo.datalayer.testdao;

import nl.scalda.pasimo.datalayer.interfaces.IDAOEducationTeam;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestDAOEducationTeam implements IDAOEducationTeam {

    private Set<EducationTeam> educationTeams;

    private TestDAOEducationTeam() {
        this.educationTeams = new TreeSet<EducationTeam>();

        // Test data
        this.educationTeams.add(new EducationTeam("AO", "Applicatieontwikkelaar"));
        this.educationTeams.add(new EducationTeam("SSC", "Shared Service Center"));
        this.educationTeams.add(new EducationTeam("MV", "Mediavormgeving"));
        
        EducationTeam firstEducationTeam = ((TreeSet<EducationTeam>) this.educationTeams).first();
        firstEducationTeam.addCoachGroup(new CoachGroup("B1"));
        firstEducationTeam.addCoachGroup(new CoachGroup("B2"));
    }

    @Override
    public void create(EducationTeam educationTeam) {
        this.educationTeams.add(educationTeam);
    }

    @Override
    public void update(EducationTeam educationTeam) {

        EducationTeam target = this.read(educationTeam.getId());

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
    public EducationTeam read(int Id) {

        for (EducationTeam educationTeam : this.educationTeams) {
            if (educationTeam.getAbbreviation().equals(Id))
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

    private static TestDAOEducationTeam instance;

    public static TestDAOEducationTeam getInstance()
    {
        if (instance == null)
            instance = new TestDAOEducationTeam();
        return instance;
    }

	@Override
	public void addTeacherToEducationTeam(Teacher teacher, EducationTeam educationTeam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeacherFromEducationTeam(Teacher teacher, EducationTeam educationTeam) {
		// TODO Auto-generated method stub
		
	}

}
