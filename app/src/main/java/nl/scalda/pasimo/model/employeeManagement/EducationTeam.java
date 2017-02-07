package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

public class EducationTeam implements Comparable<EducationTeam>{

    private String name;
    private String abbreviation;
    private TreeSet<CoachGroup> couchGroups;

    public EducationTeam() {
    }

    public EducationTeam(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public EducationTeam(String name, String abbreviation, TreeSet<CoachGroup> couchGroups) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.couchGroups = couchGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public TreeSet<CoachGroup> getCouchGroups() {
        return couchGroups;
    }

    public void setCouchGroups(TreeSet<CoachGroup> couchGroups) {
        this.couchGroups = couchGroups;
    }

    @Override
    public String toString() {
        return "EducationTeam{" + "name=" + name + ", abbreviation=" + abbreviation + ", couchGroups=" + couchGroups + '}';
    }

    @Override
    public int compareTo(EducationTeam o) {
        return abbreviation.compareTo(o.getAbbreviation());
    }

    

}
