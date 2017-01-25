package nl.scalda.pasimo.employeeManagement.model;

import nl.scalda.pasimo.employeeManagement.service.EducationTeamDAOService;

import java.util.TreeSet;

public class EducationTeam implements Comparable<EducationTeam> {

    private String abbreviation;
    private String name;
    private TreeSet<CoachGroup> coachGroups;

    //<editor-fold defaultstate="collapsed" desc="constructor">

    public EducationTeam(String abbreviation, String name) {
        this(abbreviation, name, new TreeSet<CoachGroup>());
    }

    public EducationTeam(String abbreviation, String name, TreeSet<CoachGroup> coachGroups) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.coachGroups = coachGroups;

        // Save the new EducationTeam
        EducationTeamDAOService.getInstance().create(this);

    }

    //</editor-fold>

    public void addCoachGroup(CoachGroup coachGroup) {
        this.coachGroups.add(coachGroup);

//        EducationTeamDAOService.getInstance().update(this);

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

    public TreeSet<CoachGroup> getCoachGroups() {
        return coachGroups;
    }

    public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
        this.coachGroups = coachGroups;
    }

    //</editor-fold>

    @Override
    public int compareTo(EducationTeam o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "EducationTeam{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                ", coachGroups=" + coachGroups +
                '}';
    }

}