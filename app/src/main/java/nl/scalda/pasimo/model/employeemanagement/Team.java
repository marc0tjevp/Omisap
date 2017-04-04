package nl.scalda.pasimo.model.employeemanagement;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOEducationTeam;

public class Team {

    public static final String ICT = "ict";

    /**
     * Abbreviation of the Team; e.g. ICT
     */
    private String abbreviation;

    /**
     * Name of the Team; e.g. Informatie- en Communicatietechnologie
     */
    private String name;

    private Set<EducationTeam> educationTeams;

    //<editor-fold defaultstate="collapsed" desc="constructor">


    public Team(String abbreviation, String name) {
        this(abbreviation, name, new TreeSet<EducationTeam>());
    }

    public Team(String abbreviation, String name, Set<EducationTeam> educationTeams) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.educationTeams = educationTeams;
    }

    //</editor-fold>

    /**
     * Adds an EducationTeam to the Team.
     */
    public void addEducationTeam(EducationTeam educationTeam) {
        this.educationTeams.add(educationTeam);
        MYSQLDAOEducationTeam.getInstance().create(educationTeam);
        
    }

    /**
     * Updates an EducationTeam.
     */
    public void updateEducationTeam(EducationTeam educationTeam) {
                educationTeam.setAbbreviation(educationTeam.getAbbreviation());
                educationTeam.setName(educationTeam.getName());
                MYSQLDAOEducationTeam.getInstance().update(educationTeam);
                
                
            }
  

    /**
     * Removes an EducationTeam from the Team.
     */
    public void removeEducationTeam(EducationTeam educationTeam) {
        this.educationTeams.remove(educationTeam);
        MYSQLDAOEducationTeam.getInstance().delete(educationTeam);
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EducationTeam> getEducationTeams() {
        return this.educationTeams;
    }

    public void setEducationTeams(Set<EducationTeam> educationTeams) {
        this.educationTeams = educationTeams;
    }

    //</editor-fold>

    @Override
    public String toString() {
        return "Team{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                ", educationTeams=" + educationTeams +
                '}';
    }

}